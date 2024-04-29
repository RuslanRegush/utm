class Memento:
    def __init__(self, state):
        self._state = state
    
    def get_state(self):
        return self._state

class Originator:
    def __init__(self):
        self._state = None
    
    def set_state(self, state):
        print("Setting state to:", state)
        self._state = state
    
    def save_to_memento(self):
        print("Saving state to memento")
        return Memento(self._state)
    
    def restore_from_memento(self, memento):
        print("Restoring state from memento")
        self._state = memento.get_state()
    
    def __str__(self):
        return f"Current state: {self._state}"

class Caretaker:
    def __init__(self):
        self._mementos = []
    
    def add_memento(self, memento):
        self._mementos.append(memento)
    
    def get_memento(self, index):
        return self._mementos[index]

# Usage
originator = Originator()
caretaker = Caretaker()

originator.set_state("State 1")
caretaker.add_memento(originator.save_to_memento())

originator.set_state("State 2")
caretaker.add_memento(originator.save_to_memento())

print(originator)

# Restore to previous state
originator.restore_from_memento(caretaker.get_memento(0))
print(originator)
