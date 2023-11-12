package com.example.frm.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ZonasVoo")
public class ZonaVoo extends Location{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "radius")
    public double radius;

    @Column(name = "size")
    public double size;

    @Column(name = "zonaVoo")
    public TipoZonaVoo zonaVoo;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public TipoZonaVoo getZonaVoo() {
        return zonaVoo;
    }

    public void setZonaVoo(TipoZonaVoo zonaVoo) {
        this.zonaVoo = zonaVoo;
    }

    public Boolean inPlace(Location aircraft){

        double distance = aircraft.calcDistance(this);

        if(distance < this.radius && aircraft.getHeight() > this.getHeight() && aircraft.getHeight() < this.getHeight()+this.size){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public Boolean inAltitude(double height){

        if(height >= this.getHeight() && height <= this.getHeight()+this.size){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public double[] getInterceptionVector(double[] vector, double distance){

        double routeDistance = this.getDistance(vector);
        return this.resizeVector(vector, routeDistance, distance);
    }
    public Boolean willCrossZone(Location aircraft, Location destiny){

        double[] direction = origin.getDirection(this);
        double[] route = origin.getDirection(target);

        double distance = this.calcDistance(origin);
        double[] interceptionVector = getInterceptionVector(route, distance);

        double[] ortho = this.subtractVectors(interceptionVector, direction);
        double range = this.getDistance(ortho);

        if(range < this.radius){

            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }
}
