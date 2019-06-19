package commandtests

class User {


	String firstName

	static constraints = {
		firstName shared: 'nonNullableString'
	}

	static mapping = {
		table '`user`'
	}
}
