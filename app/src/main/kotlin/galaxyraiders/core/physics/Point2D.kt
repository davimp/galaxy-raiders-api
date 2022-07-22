@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

import kotlin.math.abs
import kotlin.math.sqrt

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return Point2D(x + p.x, y + p.y)
  }

  operator fun plus(v: Vector2D): Point2D {
    return Point2D(x + v.dx, y + v.dy)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(x, y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(abs(x - p.x), abs(y - p.y))
  }

  fun impactDirection(p: Point2D): Vector2D {
    val impactVector: Vector2D = impactVector(p)
    val magnitude: Double = impactVector.magnitude
    return Vector2D(impactVector.dx / magnitude, impactVector.dy / magnitude)
  }

  fun contactVector(p: Point2D): Vector2D {
    val impactVector: Vector2D = impactVector(p)
    return Vector2D(impactVector.normal.dx, impactVector.normal.dy)
  }

  fun contactDirection(p: Point2D): Vector2D {
    val contactVector: Vector2D = contactVector(p)
    val magnitude: Double = contactVector.magnitude
    return Vector2D(contactVector.dx / magnitude, contactVector.dy / magnitude)
  }

  fun distance(p: Point2D): Double {
    val dx: Double = abs(x - p.x)
    val dy: Double = abs(y - p.y)
    return sqrt(dx * dx + dy * dy)
  }
}
