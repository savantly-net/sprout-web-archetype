#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ${groupId}.web.modules.SpotModule;
import net.savantly.sprout.core.module.registration.SproutModuleRegistration;
import net.savantly.sprout.core.module.registration.SproutModuleRegistrationRepository;

@Configuration
public class SpotAutoConfiguration {
	
	@Autowired
	SproutModuleRegistrationRepository registrations;
	@Autowired
	SpotModule module;
	
	@PostConstruct
	public void postConstruct() {
		SproutModuleRegistration shackInstallation = registrations.findOne(SpotModule.BEAN_NAME);
		if (shackInstallation == null || !shackInstallation.isInstalled()) {
			module.install();
		}
	}

}
