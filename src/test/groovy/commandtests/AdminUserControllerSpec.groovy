package commandtests

import grails.testing.web.controllers.ControllerUnitTest
import org.apache.commons.lang.RandomStringUtils
import spock.lang.Specification

class AdminUserControllerSpec extends Specification implements ControllerUnitTest<AdminUserController> {

	void testUserCommand() {
		when:
		UserCommand command = new UserCommand()

		then:
		!command.validate()
		command.errors['firstName'].code == 'nullable'

		when:
		command = new UserCommand(
				firstName: RandomStringUtils.randomAlphabetic(256)
		)

		then:
		!command.validate()
		command.errors['firstName'].code == 'maxSize.exceeded'

		when:
		command = new UserCommand(
				firstName: RandomStringUtils.randomAlphabetic(10)
		)

		then:
		command.validate()
	}
}
