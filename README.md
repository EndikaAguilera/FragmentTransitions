# FragmentsTest
Android Custom FragmentTransactions Transitions Example.

## Features
  - Vertical and Horizontal transitions.
  - Enable/Disable transitions on initial fragment load.
    - If you don't any fragment to be aninated on it's initial load, just simply call:
    ```java
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // this will make the fragment to start/load without animation
            mAnimateOpenEnter = false;

            return inflater.inflate(R.layout.your_fragment, container, false);
        }
    ```
    
## Notice
  - FragmentTransaction must be set as follows:
```java
FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
```  
  - Make sure that all the fragment you want to animate extends BaseFragment:
```java
public class YourFragment extends BaseFragment {}
```
