using System;
public class QuickFinder
{
  private int[] _array;

  public QuickFinder(int size)
  {
    _array = new int[size];
    for (int i = 0; i < size; i++)
    {
      _array[i] = i;
    }
  }
  public bool Find(int p, int q)
  {
    return _array[p] == _array[q];
  }
  public void Union(int p, int q)
  {
    var source = _array[p];
    var destination = _array[q];
    for (int i = 0; i < _array.Length; i++)
    {
      if (_array[i] == source)
        _array[i] = destination;
    }
  }

  public void Print()
  {
    for (int i = 0; i < _array.Length; i++)
    {
      Console.Write($"{_array[i]} ");
    }
    Console.WriteLine();
  }

}