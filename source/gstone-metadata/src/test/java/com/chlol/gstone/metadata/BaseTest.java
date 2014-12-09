package com.chlol.gstone.metadata;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/**/*.xml" })
public abstract class BaseTest {
	private static MongodProcess mongoProcess;
    
	@Value("mongo.port")
    private static int mongoPort;
    
	@BeforeClass
	public static void initializeDB() throws IOException {
		MongodStarter starter = MongodStarter.getDefaultInstance();
		IMongodConfig mongodConfig = new MongodConfigBuilder()
        .version(Version.Main.PRODUCTION)
        .net(new Net(mongoPort, Network.localhostIsIPv6()))
        .build();
		MongodExecutable mongoExecutable = starter.prepare(mongodConfig);
        mongoProcess = mongoExecutable.start();
	}

	@AfterClass
	public static void shutdownDB() throws InterruptedException {
		mongoProcess.stop();
	}

}
