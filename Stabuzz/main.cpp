#include<iostream>
#include<string.h>

using namespace std;

class Beverage
{
protected:
    string description;
public:
    Beverage(){
        description = "Unknown";
    }
    string getDescription() {
        return this->description;
    }
    virtual double cost() = 0;
};

class CondimentDecorator : public Beverage
{
protected:
    Beverage* beverage;
public:
    CondimentDecorator(Beverage* _beverage) 
    {
        this->beverage = _beverage;
    }
    double cost() override
    {
        return beverage->cost();
    }
};

class HouseBlend : public Beverage
{
public:
    HouseBlend(){
        this->description = "House Blend";
    }
    double cost() override
    {
        return .89;
    }
};

class DarkRoast : public Beverage
{
public:
    DarkRoast(){
        this->description = "Dark Roast";
    }
    double cost() override
    {
        return .99;
    }
};

class Decaf : public Beverage
{
public:
    Decaf(){
        this->description = "Decaf";
    }
    double cost() override
    {
        return 1.05;
    }
};

class Espresso : public Beverage
{
public:
    Espresso(){
        this->description = "Espresso";
    }
    double cost() override
    {
        return 1.99;
    }
};

class SteamedMilk : public CondimentDecorator
{
public:
    SteamedMilk(Beverage* _beverage) : CondimentDecorator(_beverage) {
        this->description = beverage->getDescription() + ", Steamed Milk";
    }
    double cost()
    {
        return beverage->cost() + .1;
    }
};

class Mocha : public CondimentDecorator
{
public:
    Mocha(Beverage* _beverage) 
        : CondimentDecorator(_beverage) 
    {
        this->description = beverage->getDescription() + ", Mocha";
    }
    double cost()
    {
        return beverage->cost() + .2;
    }
};

class Soy : public CondimentDecorator
{
public:
    Soy(Beverage* _beverage) : CondimentDecorator(_beverage) {
        this->description = beverage->getDescription() + ", Soy";
    }
    double cost()
    {
        return beverage->cost() + .15;
    }
};

class Whip : public CondimentDecorator
{
public:
    Whip(Beverage* _beverage) : CondimentDecorator(_beverage) {
        this->description = beverage->getDescription() + ", Whip";
    }
    double cost()
    {
        return beverage->cost() + .1;
    }
};

using namespace std;
int main(){

    Beverage* beverage1 = new HouseBlend;
    cout << beverage1->getDescription() << " $" << beverage1->cost() << '\n';

    Beverage* beverage2 = new DarkRoast;
    beverage2 = new Mocha(beverage2);
    beverage2 = new Mocha(beverage2);
    beverage2 = new Whip(beverage2);
    cout << beverage2->getDescription() << " $" << beverage2->cost() << '\n';

    Beverage* beverage3 = new Espresso;
    beverage3 = new SteamedMilk(beverage3);
    beverage3 = new Mocha(beverage3);
    beverage3 = new Soy(beverage3);
    beverage3 = new Whip(beverage3);
    cout << beverage3->getDescription() << " $" << beverage3->cost() << '\n';
    
    return 0;
}