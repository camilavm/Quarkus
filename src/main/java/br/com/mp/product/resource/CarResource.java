package br.com.mp.product.resource;

import br.com.mp.product.model.Car;
import java.util.List;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cars")
public class CarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> list() {
        return Car.listAll();
    }

    @POST
    @Transactional
    public Car createCar(Car car) {
        car.persist();
        return car;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Car update(@PathParam("id") Long id, Car car) {
        Car carDatabase = car.findById(id);
        carDatabase.name = car.name;

        return carDatabase;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Car.deleteById(id);
    }
}