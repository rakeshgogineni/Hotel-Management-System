package com.riario.model;

/**
 * Wallet class used to display menu information.
 *
 * @author hexware
 */
public class WalletDetails {
  private int walletId;
  private String walletType;
  private int walletAmount;

  /**
   * @param argwalletId          to initialize walletId.
   * @param argwalletType       to initialize walletType.
   * @param argwalletAmount     to initialize walletamount.
   */
  public WalletDetails(final int argwalletId, final String argwalletType, final int argwalletAmount) {

    this.walletId = argwalletId;
    this.walletType = argwalletType;
    this.walletAmount = argwalletAmount;
  }

  /**
   * default constructor.
   */
  public WalletDetails() {
  }

  /**
   * @return this walletId
   */
  public final int getWalletId() {
    return walletId;
  }

  /**
   * @param argwalletId assigns the walletId.
   */
  public final void setWalletId(final int argwalletId) {
    this.walletId = argwalletId;
  }

  /**
   * @return this walletType
   */
  public final String getWalletType() {
    return walletType;
  }

  /**
   * @param argwalletType assigns the walletType
   */
  public final void setWalletType(final String argwalletType) {
    this.walletType = argwalletType;
  }

  /**
   * @return this walletAmount
   */
  public final int getWalletAmount() {
    return walletAmount;
  }

  /**
   * @param argwalletAmount assigns the walletType
   */
  public final void setWalletAmount(final int argwalletAmount) {
    this.walletAmount = argwalletAmount;
  }
  @Override
  public final String toString() {
    return "WalletDetails [walletAmount=" + walletAmount + ", walletId=" + walletId + ", walletType=" + walletType
        + "]";
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + walletAmount;
    result = prime * result + walletId;
    int typ = 0;
    if (walletType != null) {
      typ = walletType.hashCode();
    }
    result = prime * result + typ;
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
    WalletDetails other = (WalletDetails) obj;
    if (walletAmount != other.walletAmount) {
      return false;
    }
    if (walletId != other.walletId) {
      return false;
    }
    if (walletType == null) {
      if (other.walletType != null) {
        return false;
      }
    } else if (!walletType.equals(other.walletType)) {
      return false;
    }
    return true;
  }
}
