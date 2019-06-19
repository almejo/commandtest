package commandtests

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.apache.commons.lang.RandomStringUtils
import spock.lang.Specification

@TestFor(AdminUserController)
@Mock([User])
class AdminUserControllerSpec extends Specification {

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
