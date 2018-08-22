package model;

import java.io.Serializable;

public class Name implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String firstName;
	private String lastName;

	/**
	 * Declare a default constructor as we also have a loaded one
	 */
	public Name() {
		super();
	}

	/**
	 * Loaded constructor that sets all variables on creation
	 * 
	 * @param title
	 * @param firstName
	 * @param lastName
	 */
	public Name(String title, String firstName, String lastName) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nTitle: " + title + "\nFirst Name: " + firstName + "\nLast Name: " + lastName;
	}

	/**
	 * equals method, checks title, firstName and lastName match
	 */
	@Override
	public boolean equals(Object temp) {

		if (temp == null) {
			return false;
		}

		if (temp instanceof Name) {

			Name name = (Name) temp;

			if (this.title.equalsIgnoreCase(name.title) && this.firstName.equalsIgnoreCase(name.firstName)
					&& this.lastName.equalsIgnoreCase(name.lastName)) {

				// If all variables match we return to say that the two
				// objects are the same
				return true;
			} else {

				// return false if one of the variables does not match
				return false;
			}
		}

		// return false as default as it means that the check was
		// completed
		return false;
	}
}
