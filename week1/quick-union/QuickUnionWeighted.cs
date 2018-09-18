using System;
public class QuickUnionWeighted
{

  private int[] _array;
  private int[] _sizes;
  private bool _withCompression;
   public QuickUnionWeighted(int size, bool withCompression = false)
  {
    _withCompression = withCompression;
    _array = new int[size];
    _sizes = new int[size];
    for (int i = 0; i < size; i++)
    {
      _array[i] = i;
      _sizes[i] = 1;
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
    if(sourceRoot == destinationRoot)
      return;
    if(_sizes[sourceRoot] > _sizes[destinationRoot]){
      _array[destinationRoot] = _array[sourceRoot];
      _sizes[sourceRoot] +=_sizes[destinationRoot];
    }
    else{
      _array[sourceRoot] = _array[destinationRoot];
      _sizes[destinationRoot] +=_sizes[sourceRoot];
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

  private int FindRoot(int p){
    if(_array[p] == p)
      return p;
      
    if(_withCompression){
      _array[p] = _array[_array[p]];
    }
    return FindRoot(_array[p]);
  }

}
