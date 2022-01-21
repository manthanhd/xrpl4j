package org.xrpl.xrpl4j.model.transactions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class NfTokenAcceptOfferTest {

  @Test
  public void buildTx() {

    String offer = "000B013A95F14B0044F78A264E41713C64B5F89242540EE208C3098E00000D65";
    NfTokenAcceptOffer nfTokenAcceptOffer = NfTokenAcceptOffer.builder()
      .account(Address.of("rf1BiGeXwwQoi8Z2ueFYTEXSwuJYfV2Jpn"))
      .fee(XrpCurrencyAmount.ofDrops(1))
      .buyOffer(offer)
      .build();

    assertThat(nfTokenAcceptOffer.buyOffer()).isEqualTo(Optional.of(offer));
  }

  @Test
  public void offerValueTooShort() {

    assertThrows(
      IllegalArgumentException.class,
      () -> NfTokenAcceptOffer.builder()
        .account(Address.of("rf1BiGeXwwQoi8Z2ueFYTEXSwuJYfV2Jpn"))
        .fee(XrpCurrencyAmount.ofDrops(1))
        .buyOffer("offer")
        .build(),
      "buyOffer must be 64 characters (256 bits), but was 5 characters long."
    );
  }

}
