package tech.zectrosan.xtendsearch.server;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "tech.zectrosan.xtendsearch.server.entity" })
@EnableElasticsearchRepositories(basePackages = { "tech.zectrosan.xtendsearch.server.entity" })
class Config {
	@Value("${elasticsearch.host}")
	private String esHost;

	@Value("${elasticsearch.port}")
	private int esPort;

	@Value("${elasticsearch.clustername}")
	private String esClusterName;

	@Bean
	public Client client() throws Exception {

		Settings esSettings = Settings.builder()
				.put("cluster.name", esClusterName)
		        .put("client.transport.sniff", true).build();

		TransportClient client = new PreBuiltTransportClient(esSettings);

		client.addTransportAddress(
				new TransportAddress(new InetSocketAddress(InetAddress.getByName(esHost), esPort)));

		return client;

	}

//	@Bean
//	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//		return new ElasticsearchTemplate(client());
//	}

}
