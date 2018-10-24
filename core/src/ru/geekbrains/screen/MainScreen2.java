package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Base2DScreen;

public class MainScreen2 extends Base2DScreen {

     private SpriteBatch batch;
     private Texture img;
     private Texture shape;
     private TextureRegion region;

     double length=0;
     Vector2 pos = new Vector2(10,10);
     Vector2 v = new Vector2(0,0);
     Vector2 destination = new Vector2(0,0);
     Vector2 move = new Vector2(100,100);




    @Override
    public void show() {
        super.show();
        shape = new Texture("stars.jpg");
        region = new TextureRegion(shape,256,512);
        batch = new SpriteBatch();
        img = new Texture("netscape.png");


    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(255, 0, 8, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(region, 0, 0);
        batch.draw(img, pos.x, pos.y);
        batch.end();
       // if (move.sub(destination).len()<length)
        //{
        //    v.set(0,0);
        //} else
        //{
            pos.add(v.x, v.y);
            move.set(pos);
            move.sub(destination);
            length= move.len();
            if (length<0.5f)
                v.set(0,0);
            //move.add(v.x,v.y);
        // }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        destination.set(screenX,Gdx.graphics.getHeight()-screenY);
        v.set(destination);
        v.sub(pos);
        v.nor();
        return false;
    }
}
