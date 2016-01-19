package com.frontier.augmentedtest;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import edu.dhbw.andar.interfaces.OpenGLRenderer;
import edu.dhbw.andar.util.GraphicsUtil;

public class CustomRenderer implements OpenGLRenderer {

	private float[] ambientlight1 = {.3f, .3f, .3f, .3f};
	private float[] diffuselight1 = {.7f, .7f, .7f, .7f};
	private float[] specularlight1 = {.6f, .6f, .6f, .6f};
	private float[] lightposition1 = {20, -40, 100, 1};
	
	private FloatBuffer lightPositionBuffer1 = GraphicsUtil.makeFloatBuffer(lightposition1);
	private FloatBuffer specularLightBuffer1 = GraphicsUtil.makeFloatBuffer(specularlight1);
	private FloatBuffer diffuseLightBuffer1 = GraphicsUtil.makeFloatBuffer(diffuselight1);
	private FloatBuffer ambientLightBuffer1 = GraphicsUtil.makeFloatBuffer(ambientlight1);
	
	@Override
	public void draw(GL10 arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initGL(GL10 gl) {
		gl.glDisable(GL10.GL_COLOR_MATERIAL);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glDisable(GL10.GL_COLOR_MATERIAL);
		gl.glEnable(GL10.GL_LIGHTING);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glEnable(GL10.GL_NORMALIZE);
	}

	@Override
	public void setupEnv(GL10 gl) {
		gl.glEnable(GL10.GL_LIGHTING);
		gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_AMBIENT, ambientLightBuffer1);
		gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_DIFFUSE, diffuseLightBuffer1);
		gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_SPECULAR, specularLightBuffer1);
		gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_POSITION, lightPositionBuffer1);
		gl.glEnable(GL10.GL_LIGHT1);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glDisable(GL10.GL_TEXTURE_2D);
		initGL(gl);
	}

}
