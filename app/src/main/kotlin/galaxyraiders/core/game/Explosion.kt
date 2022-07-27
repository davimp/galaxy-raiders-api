package galaxyraiders.core.game

import galaxyraiders.core.physics.Vector2D
import galaxyraiders.core.physics.Point2D

class Explosion(
  initialPosition: Point2D,
) :
  SpaceObject("Explosion", '#', initialPosition, Vector2D(0.0, 0.0), 5.0, 5.0)
