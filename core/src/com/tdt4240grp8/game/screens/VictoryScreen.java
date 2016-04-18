package com.tdt4240grp8.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tdt4240grp8.game.GeometryAssault;
import com.tdt4240grp8.game.managers.TextureManager;

public class VictoryScreen implements Screen {

    private GeometryAssault game;
    private Stage st;
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    public VictoryScreen(GeometryAssault game) {
        this.game = game;

        gamecam = new OrthographicCamera(GeometryAssault.WIDTH, GeometryAssault.HEIGHT);
        gamecam.position.set(GeometryAssault.WIDTH / 2f, GeometryAssault.HEIGHT / 2f, 0);
        gamePort = new FitViewport(GeometryAssault.WIDTH, GeometryAssault.HEIGHT, gamecam);

        st = new Stage();
        st.setViewport(gamePort);
        st.addActor(createStaticTexture("bg.png", 0, 0, st));
        Image startGameButton = new Image(TextureManager.getInstance().getTexture("startGameButton.png"));
        startGameButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                startGame();
                return true;
            }
        });
        startGameButton.setPosition(200, 200);
        st.addActor(startGameButton);
    }

    private Image createStaticTexture(String texturePath, int x, int y, Stage st) {
        Image img = new Image(TextureManager.getInstance().getTexture(texturePath));
        img.setPosition(x, y);
        return img;
    }

    private void startGame() {
        game.setScreen(new PlayScreen(game));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(st);
    }

    @Override
    public void render(float delta) {
        st.draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
