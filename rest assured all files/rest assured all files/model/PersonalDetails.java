package com.hexaware.MLP269.model;

/**
 * PersonalDetails class used to display menu information.
 *
 * @author hexware
 */
public class PersonalDetails {
  private int guestId;
  private String guestName;
  private String address;
  private long phoneNo;
  private String email;
  private String username;
  private String password;

  /**
   * Default Constructor.
   */
  public PersonalDetails() {

  }

  /**
   * @param argguestId   to initialize guestId.
   * @param argguestName to initialize guestName.
   * @param argaddress   to initialize address.
   * @param argphoneNo   to initialize phoneNo.
   * @param argemail     to initialize email.
   * @param argusername  to initialize username.
   * @param argpassword  to initialize password. used to get details through
   *                     constructor.
   */
  public PersonalDetails(final int argguestId, final String argguestName, final String argaddress,
      final long argphoneNo, final String argemail, final String argusername, final String argpassword) {
    this.guestId = argguestId;
    this.guestName = argguestName;
    this.address = argaddress;
    this.phoneNo = argphoneNo;
    this.email = argemail;
    this.username = argusername;
    this.password = argpassword;
  }

  /**
   * @return this guestId.
   */
  public final int getGuestId() {
    return guestId;
  }

  /**
   * @param argguestId assigns the guestId.
   */
  public final void setGuestId(final int argguestId) {
    this.guestId = argguestId;
  }

  /**
   * @return this guestName.
   */
  public final String getGuestName() {
    return guestName;
  }

  /**
   * @param argguestName assigns the guestName.
   */
  public final void setGuestName(final String argguestName) {
    this.guestName = argguestName;
  }

  /**
   * @return this address.
   */
  public final String getAddress() {
    return address;
  }

  /**
   * @param argaddress assigns the address.
   */
  public final void setAddress(final String argaddress) {
    this.address = argaddress;
  }

  /**
   * @return this phoneNo.
   */
  public final long getPhoneNo() {
    return phoneNo;
  }

  /**
   * @param argphoneNo assigns the phoneNo.
   */
  public final void setPhoneNo(final long argphoneNo) {
    this.phoneNo = argphoneNo;
  }

  /**
   * @return this email.
   */
  public final String getEmail() {
    return email;
  }

  /**
   * @param argemail assigns the email.
   */
  public final void setEmail(final String argemail) {
    this.email = argemail;
  }

  /**
   * @return this username.
   */
  public final String getUsername() {
    return username;
  }

  /**
   * @param argusername assigns username.
   */
  public final void setUsername(final String argusername) {
    this.username = argusername;
  }

  /**
   * @return this password.
   */
  public final String getPassword() {
    return password;
  }

  /**
   * @param argpassword assigns password.
   */
  public final void setPassword(final String argpassword) {
    this.password = argpassword;
  }

  @Override
  public final String toString() {
    return "PersonalDetails [address=" + address + ", email=" + email + ", guestId=" + guestId + ", guestName="
        + guestName + ", password=" + password + ", phoneNo=" + phoneNo + ", username=" + username + "]";
  }

  /**
   * @param argguestId to initialize guestId.
   * @param argaddress to initialize address.
   * @param argphoneNo to initialize phoneNo
   */
  public PersonalDetails(final int argguestId, final String argaddress, final long argphoneNo) {
    this.guestId = argguestId;
    this.address = argaddress;
    this.phoneNo = argphoneNo;
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    int val1 = 0;
    if (address != null) {
      val1 = address.hashCode();
    }
    result = prime * result + val1;
    int val2 = 0;
    if (email != null) {
      val2 = email.hashCode();
    }
    result = prime * result + val2;
    result = prime * result + guestId;
    int val3 = 0;
    if (guestName != null) {
      val3 = guestName.hashCode();
    }
    result = prime * result + val3;
    int val4 = 0;
    if (password != null) {
      val4 = password.hashCode();
    }
    result = prime * result + val4;
    result = prime * result + (int) (phoneNo ^ (phoneNo >>> 32));
    int val5 = 0;
    if (username != null) {
      val5 = username.hashCode();
    }
    result = prime * result + val5;
    return result;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    PersonalDetails other = (PersonalDetails) obj;
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!address.equals(other.address)) {
      return false;
    }
    if (email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!email.equals(other.email)) {
      return false;
    }
    if (guestId != other.guestId) {
      return false;
    }
    if (guestName == null) {
      if (other.guestName != null) {
        return false;
      }
    } else if (!guestName.equals(other.guestName)) {
      return false;
    }
    if (password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!password.equals(other.password)) {
      return false;
    }
    if (phoneNo != other.phoneNo) {
      return false;
    }
    if (username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!username.equals(other.username)) {
      return false;
    }
    return true;
  }

}
