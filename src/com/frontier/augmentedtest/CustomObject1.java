package com.frontier.augmentedtest;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import edu.dhbw.andar.ARObject;
import edu.dhbw.andar.pub.SimpleBox;
import edu.dhbw.andar.util.GraphicsUtil;

public class CustomObject1 extends ARObject {

	private SimpleBox box = new SimpleBox();
	private FloatBuffer mat_ambient;
	private FloatBuffer mat_flash;
	private FloatBuffer mat_diffuse;
	private FloatBuffer mat_flash_shiny;
	
	public CustomObject1(String name, String patternName, double markerWidth,
			double[] markerCenter) {
		super(name, patternName, markerWidth, markerCenter);

		float mat_ambientf[] = { 0, 1, 0, 1 };
		float mat_flashf[] = { 0, 1, 0, 1 };
		float mat_diffusef[] = { 0, 1, 0, 1 };
		float mat_flash_shinyf[] = { 50 };

		mat_ambient = GraphicsUtil.makeFloatBuffer(mat_ambientf);
		mat_flash = GraphicsUtil.makeFloatBuffer(mat_flashf);
		mat_diffuse = GraphicsUtil.makeFloatBuffer(mat_diffusef);
		mat_flash_shiny = GraphicsUtil.makeFloatBuffer(mat_flash_shinyf);
	}

	public CustomObject1(String name, String patternName, double markerWidth,
			double[] markerCenter, float[] customColor) {
		super(name, patternName, markerWidth, markerCenter);
		float mat_flash_shinyf[] = {50};
		
		mat_ambient = GraphicsUtil.makeFloatBuffer(customColor);
		mat_flash = GraphicsUtil.makeFloatBuffer(customColor);
		mat_diffuse = GraphicsUtil.makeFloatBuffer(customColor);
		mat_flash_shiny = GraphicsUtil.makeFloatBuffer(customColor);
	}

	@Override
	public void init(GL10 arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void draw(GL10 gl) {
		// TODO Auto-generated method stub
		super.draw(gl);
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, mat_flash);
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, mat_flash_shiny);
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, mat_diffuse);
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, mat_ambient);
		gl.glColor4f(0, 1, 0, 1);
		gl.glTranslatef(0, 0, 12.5f);
		
		box.draw(gl);
	}

	
}
