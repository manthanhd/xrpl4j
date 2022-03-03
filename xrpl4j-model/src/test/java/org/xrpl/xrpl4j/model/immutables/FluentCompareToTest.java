package org.xrpl.xrpl4j.model.immutables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.google.common.primitives.UnsignedInteger;
import org.junit.jupiter.api.Test;

public class FluentCompareToTest {

  static UnsignedInteger SMALLER = UnsignedInteger.valueOf(1);
  static UnsignedInteger BIGGER = UnsignedInteger.valueOf(100);
  static UnsignedInteger MAX_UINT = UnsignedInteger.MAX_VALUE;

  @Test
  public void simpleTest() {
    assert (FluentCompareTo.is(SMALLER).equalTo(SMALLER));
    assert (FluentCompareTo.is(BIGGER).equalTo(BIGGER));
    assert (FluentCompareTo.is(SMALLER).notEqualTo(BIGGER));
    assert (FluentCompareTo.isNot(SMALLER).notEqualTo(BIGGER));
    assert (FluentCompareTo.isNot(SMALLER).equalTo(SMALLER));

    assert (FluentCompareTo.is(SMALLER).lessThanOrEqualTo(SMALLER));
    assert (FluentCompareTo.is(SMALLER).lessThanOrEqualTo(BIGGER));
    assert (FluentCompareTo.is(SMALLER).lessThan(BIGGER));
    assert (FluentCompareTo.is(SMALLER).notGreaterThan(BIGGER));
    assert (FluentCompareTo.is(SMALLER).notGreaterThanEqualTo(BIGGER));
    assertFalse(FluentCompareTo.is(SMALLER).greaterThan(SMALLER));
    assertFalse(FluentCompareTo.is(SMALLER).lessThan(SMALLER));

    assert (FluentCompareTo.is(BIGGER).greaterThanEqualTo(BIGGER));
    assert (FluentCompareTo.is(BIGGER).greaterThanEqualTo(SMALLER));
    assert (FluentCompareTo.is(BIGGER).greaterThan(SMALLER));
    assert (FluentCompareTo.is(BIGGER).notLessThan(SMALLER));
    assert (FluentCompareTo.is(BIGGER).notLessThanOrEqualTo(SMALLER));
    assertFalse(FluentCompareTo.is(BIGGER).greaterThan(BIGGER));
    assertFalse(FluentCompareTo.is(BIGGER).lessThan(BIGGER));

    assert (FluentCompareTo.is(SMALLER).between(SMALLER, MAX_UINT));
    assertFalse(FluentCompareTo.is(BIGGER).betweenExclusive(SMALLER, BIGGER));
    assert (FluentCompareTo.is(MAX_UINT).notBetween(SMALLER, BIGGER));
    assertFalse(FluentCompareTo.is(BIGGER).notBetweenExclusive(SMALLER, MAX_UINT));

    assertThat(FluentCompareTo.is(SMALLER).getValue()).isEqualTo(UnsignedInteger.valueOf(1));
    assertThat(FluentCompareTo.is(BIGGER).getValue()).isEqualTo(UnsignedInteger.valueOf(100));
    assertThat(FluentCompareTo.is(SMALLER)).isNotEqualTo(FluentCompareTo.is(BIGGER));

    assert (FluentCompareTo.is(MAX_UINT).equalTo(MAX_UINT));
    assertFalse(FluentCompareTo.is(MAX_UINT).greaterThan(MAX_UINT));
    assertFalse(FluentCompareTo.is(MAX_UINT).lessThan(MAX_UINT));
  }
}
