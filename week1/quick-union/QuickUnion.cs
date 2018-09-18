using System;
public class QuickUnion
{
  private int[] _array;
  private bool _withCompression;
   public QuickUnion(int size, bool withCompression = false)
  {
    _withCompression = withCompression;
    _array = new int[size];
    for (int i = 0; i < size; i++)
    {
      _array[i] = i;
    }
  }
  public bool Find(int p, int q)
  {
    return FindRoot(p) == FindRoot(q);
  }
  
  public void Union(int p, int q)
  {
    var sourceRoot = FindRoot(p);
    var destinationRoot = FindRoot(q);
     _array[sourceRoot] = _array[destinationRoot];
  }

  public void Print()
  {
    for (int i = 0; i < _array.Length; i++)
    {
      Console.Write($"{_array[i]} ");
    }
    Console.WriteLine();
  }

  private int FindRoot(int p){
    if(_array[p] == p)
      return p;
    
    if(_withCompression){
      _array[p] = _array[_array[p]];
    }
    return FindRoot(_array[p]);
  }

}
