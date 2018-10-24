package ru.geekbrains;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import ru.geekbrains.screen.MainScreen2;

public class StarGame2D extends Game {

    @Override
    public void create() {
            setScreen(new MainScreen2());

    }

}
