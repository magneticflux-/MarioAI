package ch.idsia.agents.controllers;

import ch.idsia.benchmark.mario.engine.LevelScene;
import ch.idsia.benchmark.mario.engine.VisualizationComponent;
import ch.idsia.benchmark.mario.environments.IEnvironment;

import java.awt.Graphics;

public interface IMarioDebugDraw {

    public void debugDraw(VisualizationComponent vis, LevelScene level, IEnvironment env, Graphics g);

}
