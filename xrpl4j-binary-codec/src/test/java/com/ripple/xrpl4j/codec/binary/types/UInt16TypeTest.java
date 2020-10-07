package com.ripple.xrpl4j.codec.binary.types;

import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.util.stream.Stream;

class UInt16TypeTest extends BaseSerializerTypeTest {

  private final static UInt16Type codec = new UInt16Type();

  @Override
  SerializedType getType() {
    return codec;
  }

  private static Stream<Arguments> dataDrivenFixtures() throws IOException {
    return dataDrivenFixturesForType(codec);
  }

}
