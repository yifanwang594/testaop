package com.van.model;

/**
 * @author: Van
 * @create: 2020-04-03 12:22
 * @description: 工厂模式的工厂类
 * @program: testaop
 * @version: 1.0
 **/
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } /*else if (type.equals("clam")) {
            pizza = new ClamPizza();

        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();

        } else if (type.equals("veggie")) {
            pizza = new VeggiePizze();

        }*/
        return pizza;
    }
}

abstract class Pizza {
    public abstract void prepare();

    public abstract void bake();

    public abstract void cut();

    public abstract void box();
}

class CheesePizza extends Pizza {
    @Override
    public void bake() {
        System.out.println("bake CheesePizza ...");
    }

    @Override
    public void box() {
        System.out.println("box CheesePizza ...");
    }

    @Override
    public void cut() {
        System.out.println("cut CheesePizza ...");
    }

    @Override
    public void prepare() {
        System.out.println("prepare CheesePizza ...");
    }
}

class PizzaStore {
    SimplePizzaFactory factory;      //SimplePizzaFactory的引用

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = factory.createPizza(type);       //使用工厂对象的创建方法，而不是直接new。这里不再使用具体实例化

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}