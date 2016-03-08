package org.elsys.learn;

public class Name {

	private String firstName;
	private String lastName;

	public Name(String first, String last) {
		firstName = first;
		lastName = last;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

//	@Override
//	public int hashCode() {
//		return firstName.hashCode() + 31 * lastName.hashCode();
//	}

	// @Override
	// public boolean equals(Object other) {
	// if( other instanceof Name) {
	// Name name = (Name) other;
	// return firstName.equals(name.firstName) &&
	// lastName.equals(name.lastName);
	// }
	// return false;
	// }

}
