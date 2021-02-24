package com.hexaware.MLP269.model;

/**
 * Offer class used to display menu information.
 *
 * @author hexware
 */
public class Offer {
  private int offerId;
  private String offerName;
  private float offerValue;

  /**
   * Default Constructor.
   */
  public Offer() {
  }

  /**
   * @param argOfferId    to initialize offerId.
   * @param argOfferName  to initialize offerName.
   * @param argOfferValue to initialize offerValue. used to get details through
   *                      constructor.
   */
  public Offer(final int argOfferId, final String argOfferName, final float argOfferValue) {
    this.offerId = argOfferId;
    this.offerName = argOfferName;
    this.offerValue = argOfferValue;
  }

  /**
   * @return this offerId.
   */
  public final int getOfferId() {
    return offerId;
  }

  /**
   * @param argOfferId assigns the offerId.
   */
  public final void setOfferId(final int argOfferId) {
    this.offerId = argOfferId;
  }

  /**
   * @return this offerName.
   */
  public final String getOfferName() {
    return offerName;
  }

  /**
   * @param argOfferName assigns the offerName.
   */
  public final void setOfferName(final String argOfferName) {
    this.offerName = argOfferName;
  }

  /**
   * @return this offerValue.
   */
  public final float getOfferValue() {
    return offerValue;
  }

  /**
   * @param argOfferValue assigns the offerValue.
   */
  public final void setOfferValue(final float argOfferValue) {
    this.offerValue = argOfferValue;
  }

  @Override
  public final String toString() {
    return "Offer [offerId=" + offerId + ", offerName=" + offerName + ", offerValue=" + offerValue + "]";
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + offerId;
    int value = 0;
    if (offerName != null) {
      value = offerName.hashCode();
    }
    result = prime * result + value;
    result = prime * result + Float.floatToIntBits(offerValue);
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
    Offer other = (Offer) obj;
    if (offerId != other.offerId) {
      return false;
    }
    if (offerName == null) {
      if (other.offerName != null) {
        return false;
      }
    } else if (!offerName.equals(other.offerName)) {
      return false;
    }
    if (Float.floatToIntBits(offerValue) != Float.floatToIntBits(other.offerValue)) {
      return false;
    }
    return true;
  }

}
