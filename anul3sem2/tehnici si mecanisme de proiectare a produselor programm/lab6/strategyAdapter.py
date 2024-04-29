# Interface for sorting algorithms
class SortStrategy:
  def sort(self, data):
    pass

# Concrete sorting strategies (implementations)
class BubbleSort(SortStrategy):
  def sort(self, data):
    # Implement bubble sort logic here
    swapped = True
    while swapped:
      swapped = False
      for i in range(len(data) - 1):
        if data[i] > data[i + 1]:
          data[i], data[i + 1] = data[i + 1], data[i]
          swapped = True

class SelectionSort(SortStrategy):
  def sort(self, data):
    # Implement selection sort logic here
    for i in range(len(data)):
      min_index = i
      for j in range(i + 1, len(data)):
        if data[j] < data[min_index]:
          min_index = j
      data[i], data[min_index] = data[min_index], data[i]

# Adapter for incompatible sorting function
class LegacySortAdapter(SortStrategy):
  def __init__(self, legacy_sort_function):
    self.legacy_sort_function = legacy_sort_function

  def sort(self, data):
    self.legacy_sort_function(data)  # Call the legacy function

# Usage example
def sort_data(data, sort_strategy):
  sort_strategy.sort(data)

# Legacy sorting function (incompatible interface)
def legacy_sort(data):
  # Implement legacy sorting logic here (e.g., using built-in sort)
  data.sort()

# Use strategy pattern with different sorting algorithms
data = [5, 2, 8, 1, 3]
print(data) # Output: [5, 2, 8, 1, 3]
bubble_sort = BubbleSort()
sort_data(data, bubble_sort)
print(data)  # Output: [1, 2, 3, 5, 8]
selection_sort = SelectionSort()
sort_data(data.copy(), selection_sort)
print(data)  # Output: [1, 2, 3, 5, 8]

# Use adapter pattern to integrate legacy sorting function
legacy_adapter = LegacySortAdapter(legacy_sort)
sort_data(data.copy(), legacy_adapter)
print(data)  # Output: [1, 2, 3, 5, 8]
