package com.mawitnow.lawnmower.domain

import com.mawitnow.lawnmower.domain.Direction._
import org.scalatest.FunSuite

class TestDirection extends FunSuite {

  test(" A valid char direction  should be converted to the corresponding Direction object") {
    assert(Direction.from('N') == N)
    assert(Direction.from('E') == E)
    assert(Direction.from('W') == W)
    assert(Direction.from('S') == S)
  }

  test("The right of the North should be the Est") {
    assert(N.right() == E)
    assert(E.right() == S)
    assert(S.right() == W)
    assert(W.right() == N)

    assert(N.left() == W)
    assert(E.left() == N)
    assert(S.left() == E)
    assert(W.left() == S)
  }


}
