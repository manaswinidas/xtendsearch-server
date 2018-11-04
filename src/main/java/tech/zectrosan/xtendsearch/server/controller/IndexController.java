package tech.zectrosan.xtendsearch.server.controller;

import java.lang.management.ManagementFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@RestController()
public class IndexController {

	class UptimeResponse {
		@Getter @Setter private long uptime;
		@Getter @Setter private long currentTime;
		@Getter @Setter private String status;
		
		UptimeResponse() {
			this.uptime = ManagementFactory.getRuntimeMXBean().getUptime();
			this.currentTime = System.currentTimeMillis();
			this.status = "OK";
		}
	}
	
    @RequestMapping("/")
    public UptimeResponse index() {
        return new UptimeResponse();
    }
}