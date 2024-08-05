package pl.jacpio.utiles;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

import static pl.jacpio.utiles.Constants.tileSize;

public class MapOperations {
    public static void prepareMap(TiledMap map, World world) {
        for (int mapNo = 1; mapNo < map.getLayers().getCount(); mapNo++) {
            TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(mapNo);
            for (int x = 0; x < layer.getWidth(); x++) {
                for (int y = 0; y < layer.getHeight(); y++) {
                    TiledMapTileLayer.Cell cell = layer.getCell(x, y);
                    if (cell == null) continue;
                    MapObjects cellObjects = cell.getTile().getObjects();
                    if (cellObjects.getCount() == 0) continue;
                    for (int i = 0; i < cellObjects.getCount(); i++) {
                        MapObject mapObject = cellObjects.get(i);
                        if (mapObject instanceof RectangleMapObject) {
                            RectangleMapObject rectangleMapObject = (RectangleMapObject) mapObject;
                            Rectangle rectangle = rectangleMapObject.getRectangle();
                            BodyDef bodyDef = createBodyDef(x * tileSize + tileSize/2f + rectangle.getX() - (tileSize - rectangle.getWidth())/2f,
                                y * tileSize + tileSize/2f + rectangle.getY() - (tileSize - rectangle.getHeight())/2f);
                            Body body = world.createBody(bodyDef);
                            PolygonShape shape = new PolygonShape();
                            shape.setAsBox(rectangle.getWidth()/2f, rectangle.getHeight()/2f);
                            body.createFixture(shape, 0.0f);
                            shape.dispose();
                        }else if (mapObject instanceof PolygonMapObject) {
                            PolygonMapObject polygonMapObject = (PolygonMapObject) mapObject;
                            Polygon polygon = polygonMapObject.getPolygon();
                            BodyDef bodyDef = createBodyDef(x * tileSize + polygon.getX(), y * tileSize + polygon.getY());
                            Body body = world.createBody(bodyDef);
                            PolygonShape shape = new PolygonShape();
                            shape.set(polygon.getVertices());
                            body.createFixture(shape, 0.0f);
                            shape.dispose();
                        } else if (mapObject instanceof EllipseMapObject) {
                            EllipseMapObject ellipseMapObject = (EllipseMapObject) mapObject;
                            Ellipse ellipse = ellipseMapObject.getEllipse();
                            if (ellipse.width == ellipse.height) continue;
                            BodyDef bodyDef = createBodyDef(x * tileSize + tileSize/2f + ellipse.x, y * tileSize + tileSize/2f + ellipse.y);
                            Body body = world.createBody(bodyDef);
                            CircleShape shape = new CircleShape();
                            shape.setRadius(ellipse.width/2f);
                            body.createFixture(shape, 0.0f);
                            shape.dispose();
                        }
                    }
                }
            }
        }
    }

    private static BodyDef createBodyDef(float x, float y) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);
        return bodyDef;
    }
}
