package jfxtras.labs.scene.control.gauge.linear;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import jfxtras.labs.internal.scene.control.gauge.linear.skin.LinearGaugeSkin;
import jfxtras.labs.scene.control.gauge.linear.elements.Indicator;
import jfxtras.labs.scene.control.gauge.linear.elements.Label;
import jfxtras.labs.scene.control.gauge.linear.elements.Marker;
import jfxtras.labs.scene.control.gauge.linear.elements.Segment;

/**
 * This class contains commonalities for all linear gauges
 */
abstract public class LinearGauge<T> extends Control {
	
	// ==================================================================================================================
	// CONSTRUCTOR

	/**
	 */
	public LinearGauge() {
		construct();
	}

	/*
	 * 
	 */
	private void construct() {
		
		// setup the CSS
		this.getStyleClass().add(this.getClass().getSimpleName());
	}
	

	// ==================================================================================================================
	// ABSTRACT

	@Override abstract public String getUserAgentStylesheet();

	@Override abstract public Skin<?> createDefaultSkin();

	
	// ==================================================================================================================
	// PROPERTIES

	/** value: the currently rendered value */
	public DoubleProperty valueProperty() { return valueProperty; }
	final private DoubleProperty valueProperty = new SimpleDoubleProperty(this, "value", 0.0);
	public double getValue() { return valueProperty.getValue(); }
	public void setValue(double value) { valueProperty.setValue(value); }
	@SuppressWarnings("unchecked")
	public T withValue(double value) { setValue(value); return (T)this; } 

	/** minValue: the lowest value of the gauge */
	public DoubleProperty minValueProperty() { return minValueProperty; }
	final private DoubleProperty minValueProperty = new SimpleDoubleProperty(this, "minValue", 0.0);
	public double getMinValue() { return minValueProperty.getValue(); }
	public void setMinValue(double value) { minValueProperty.setValue(value); }
	@SuppressWarnings("unchecked")
	public T withMinValue(double value) { setMinValue(value); return (T)this; } 

	/** maxValue: the highest value of the gauge */
	public DoubleProperty maxValueProperty() { return maxValueProperty; }
	final private DoubleProperty maxValueProperty = new SimpleDoubleProperty(this, "maxValue", 100.0);
	public double getMaxValue() { return maxValueProperty.getValue(); }
	public void setMaxValue(double value) { maxValueProperty.setValue(value); }
	@SuppressWarnings("unchecked")
	public T withMaxValue(double value) { setMaxValue(value); return (T)this; } 

	/** labels */
	public ObservableList<Label> labels() { return labels; }
	final private ObservableList<Label> labels =  javafx.collections.FXCollections.observableArrayList();

	/** segments */
	public ObservableList<Segment> segments() { return segments; }
	final private ObservableList<Segment> segments =  javafx.collections.FXCollections.observableArrayList();

	/** markers */
	public ObservableList<Marker> markers() { return markers; }
	final private ObservableList<Marker> markers =  javafx.collections.FXCollections.observableArrayList();

	/** indicators */
	public ObservableList<Indicator> indicators() { return indicators; }
	final private ObservableList<Indicator> indicators =  javafx.collections.FXCollections.observableArrayList();
	public static String segmentColorschemeCSSPath() {
		return LinearGaugeSkin.class.getResource("/jfxtras/labs/internal/scene/control/gauge/linear/_segment.css").toExternalForm();
	}
}
