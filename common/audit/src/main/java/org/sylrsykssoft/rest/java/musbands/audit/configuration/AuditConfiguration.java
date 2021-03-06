package org.sylrsykssoft.rest.java.musbands.audit.configuration;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Audit configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfiguration {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new SecurityAuditor();
	}

	@Bean
	public AuditingEntityListener createAuditingListener() {
		return new AuditingEntityListener();
	}

	/**
	 * Get current auditor.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	public static class SecurityAuditor implements AuditorAware<String> {
		@Override
		public Optional<String> getCurrentAuditor() {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Optional<Authentication> username = Optional.ofNullable(auth);
			return Optional.of(username
					.flatMap((input) -> (input == null) ? Optional.of("adminTest") : Optional.of(input.getName()))
					.orElseGet(() -> "adminTest"));
		}
	}
}
