package com.hexaware.MLP269.integration.test;
class TransactionDetails {
  private int guestId;
  private int walletId;
  private int transactionId;
  private int credit;
  private int debit;

  /**
   * @param argguestId       to initialize guestId.
   * @param argwalletId      to initialize walletId.
   * @param argtransactionId to initialize transactionId.
   * @param argcredit        to initialize deposit amount.
   * @param argdebit         to initialize withdrwal amount. used to get details
   *                         through constructor.
   */
  public TransactionDetails(final int argguestId, final int argwalletId, final int argtransactionId,
      final int argcredit, final int argdebit) {
    this.guestId = argguestId;
    this.walletId = argwalletId;
    this.transactionId = argtransactionId;
    this.credit = argcredit;
    this.debit = argdebit;
  }

  /**
   * default constructor.
   */
  public TransactionDetails() {
  }

  /**
   * @return this guestId
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
   * @return this walletId
   */
  public final int getWalletId() {
    return walletId;
  }

  /**
   * @param argwalletId assigns the walletId
   */
  public final void setWalletId(final int argwalletId) {
    this.walletId = argwalletId;
  }

  /**
   * @return this transactionId
   */
  public final int getTransactionId() {
    return transactionId;
  }

  /**
   * @param argtransactionId assigns the walletId
   */
  public final void setTransactionId(final int argtransactionId) {
    this.transactionId = argtransactionId;
  }

  /**
   * @return this credit
   */
  public final int getCredit() {
    return credit;
  }

  /**
   * @param argcredit assigns the credit
   */
  public final void setCredit(final int argcredit) {
    this.credit = argcredit;
  }

  /**
   * @return this withdrwalAmount
   */
  public final int getDebit() {
    return debit;
  }

  /**
   * @param argdebit assigns the credit
   */
  public final void setDebit(final int argdebit) {
    this.debit = argdebit;
  }

  @Override
  public final String toString() {
    return "TransactionDetails [guestId=" + guestId + ", transactionId=" + transactionId + ", walletId="
        + walletId + ", debit=" + debit + ",credit=" + credit + "]";
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + credit;
    result = prime * result + debit;
    result = prime * result + guestId;
    result = prime * result + transactionId;
    result = prime * result + walletId;
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
    TransactionDetails other = (TransactionDetails) obj;
    if (credit != other.credit) {
      return false;
    }
    if (debit != other.debit) {
      return false;
    }
    if (guestId != other.guestId) {
      return false;
    }
    if (transactionId != other.transactionId) {
      return false;
    }
    if (walletId != other.walletId) {
      return false;
    }
    return true;
  }
}

