class Ingredient:
    def __init__(self, nume, pret, descriere):
        self.nume = nume
        self.pret = pret
        self.descriere = descriere

class Pizza:
    def __init__(self, nume, ingrediente):
        self.nume = nume
        self.ingrediente = ingrediente
        self.pret_total = sum(ingredient.pret for ingredient in ingrediente)

    def __str__(self):
        return f"Pizza {self.nume}:\n" + "\n".join(
            f"- {ingredient.nume} ({ingredient.pret} lei): {ingredient.descriere}"
            for ingredient in self.ingrediente
        )

class PizzaBuilder:
    def __init__(self):
        self.nume = None
        self.ingrediente = []

    def set_nume(self, nume):
        self.nume = nume
        return self

    def add_ingredient(self, ingredient):
        self.ingrediente.append(ingredient)
        return self

    def build(self):
        return Pizza(self.nume, self.ingrediente)

# Exemplu de utilizare

builder = PizzaBuilder()
pizza = builder.set_nume("Margherita") \
               .add_ingredient(Ingredient("sos de rosii", 5, "Sos de rosii proaspat")) \
               .add_ingredient(Ingredient("branza mozzarella", 10, "Branza mozzarella italiana")) \
               .add_ingredient(Ingredient("busuioc", 2, "Frunze de busuioc proaspete")) \
               .build()

print(pizza)
