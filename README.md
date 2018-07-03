Android Custom FragmentTransactions Transitions Example.

## Features
  - Vertical and Horizontal transitions.
  - Enable/Disable transitions on initial fragment load.
    - If you don't any fragment to be animated on it's initial load, just simply call:
```java
@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  // this will make the fragment to start/load without animation
  AnimateOpenEnter = false;
  return inflater.inflate(R.layout.your_fragment, container, false);
}
```
    
## Notice
  - FragmentTransaction must be set as follows:
```java
FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
```  
  - Make sure that all the fragments you want to animate extends BaseFragment:
```java
public class YourFragment extends BaseFragment {}
```

## Horizontal Transitions Demo
  ![screen](https://raw.githubusercontent.com/endikaaguilera/myreposassets/master/fragment_transitions/ft_horizontal.gif)

## Vertical Transitions Demo
  ![screen](https://raw.githubusercontent.com/endikaaguilera/myreposassets/master/fragment_transitions/ft_vertical.gif)
