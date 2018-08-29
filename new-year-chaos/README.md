.MathJax\_SVG\_Display {text-align: center; margin: 1em 0em; position: relative; display: block!important; text-indent: 0; max-width: none; max-height: none; min-width: 0; min-height: 0; width: 100%} .MathJax\_SVG .MJX-monospace {font-family: monospace} .MathJax\_SVG .MJX-sans-serif {font-family: sans-serif} .MathJax\_SVG {display: inline; font-style: normal; font-weight: normal; line-height: normal; font-size: 100%; font-size-adjust: none; text-indent: 0; text-align: left; text-transform: none; letter-spacing: normal; word-spacing: normal; word-wrap: normal; white-space: nowrap; float: none; direction: ltr; max-width: none; max-height: none; min-width: 0; min-height: 0; border: 0; padding: 0; margin: 0} .MathJax\_SVG \* {transition: none; -webkit-transition: none; -moz-transition: none; -ms-transition: none; -o-transition: none} .mjx-svg-href {fill: blue; stroke: blue} .MathJax\_SVG\_LineBox {display: table!important} .MathJax\_SVG\_LineBox span {display: table-cell!important; width: 10000em!important; min-width: 0; max-width: none; padding: 0; border: 0; margin: 0}

It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their _initial_ position in the queue. Initial positions increment by from at the front of the line to at the back.

Any person in the queue can bribe the person _directly in front_ of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe _at most two others_. For example, if and bribes , the queue will look like this: .

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!

**Function Description**

Complete the function _minimumBribes_ in the editor below. It must print an integer representing the minimum number of bribes necessary, or `Too chaotic` if the line configuration is not possible.

minimumBribes has the following parameter(s):

*   _q_: an array of integers

**Input Format**

.MathJax\_SVG\_Display {text-align: center; margin: 1em 0em; position: relative; display: block!important; text-indent: 0; max-width: none; max-height: none; min-width: 0; min-height: 0; width: 100%} .MathJax\_SVG .MJX-monospace {font-family: monospace} .MathJax\_SVG .MJX-sans-serif {font-family: sans-serif} .MathJax\_SVG {display: inline; font-style: normal; font-weight: normal; line-height: normal; font-size: 100%; font-size-adjust: none; text-indent: 0; text-align: left; text-transform: none; letter-spacing: normal; word-spacing: normal; word-wrap: normal; white-space: nowrap; float: none; direction: ltr; max-width: none; max-height: none; min-width: 0; min-height: 0; border: 0; padding: 0; margin: 0} .MathJax\_SVG \* {transition: none; -webkit-transition: none; -moz-transition: none; -ms-transition: none; -o-transition: none} .mjx-svg-href {fill: blue; stroke: blue} .MathJax\_SVG\_LineBox {display: table!important} .MathJax\_SVG\_LineBox span {display: table-cell!important; width: 10000em!important; min-width: 0; max-width: none; padding: 0; border: 0; margin: 0}

The first line contains an integer , the number of test cases.

Each of the next pairs of lines are as follows:  
\- The first line contains an integer , the number of people in the queue  
\- The second line has space-separated integers describing the final state of the queue.

**Constraints**

.MathJax\_SVG\_Display {text-align: center; margin: 1em 0em; position: relative; display: block!important; text-indent: 0; max-width: none; max-height: none; min-width: 0; min-height: 0; width: 100%} .MathJax\_SVG .MJX-monospace {font-family: monospace} .MathJax\_SVG .MJX-sans-serif {font-family: sans-serif} .MathJax\_SVG {display: inline; font-style: normal; font-weight: normal; line-height: normal; font-size: 100%; font-size-adjust: none; text-indent: 0; text-align: left; text-transform: none; letter-spacing: normal; word-spacing: normal; word-wrap: normal; white-space: nowrap; float: none; direction: ltr; max-width: none; max-height: none; min-width: 0; min-height: 0; border: 0; padding: 0; margin: 0} .MathJax\_SVG \* {transition: none; -webkit-transition: none; -moz-transition: none; -ms-transition: none; -o-transition: none} .mjx-svg-href {fill: blue; stroke: blue} .MathJax\_SVG\_LineBox {display: table!important} .MathJax\_SVG\_LineBox span {display: table-cell!important; width: 10000em!important; min-width: 0; max-width: none; padding: 0; border: 0; margin: 0}

**Subtasks**

For score  
For score

**Output Format**

.MathJax\_SVG\_Display {text-align: center; margin: 1em 0em; position: relative; display: block!important; text-indent: 0; max-width: none; max-height: none; min-width: 0; min-height: 0; width: 100%} .MathJax\_SVG .MJX-monospace {font-family: monospace} .MathJax\_SVG .MJX-sans-serif {font-family: sans-serif} .MathJax\_SVG {display: inline; font-style: normal; font-weight: normal; line-height: normal; font-size: 100%; font-size-adjust: none; text-indent: 0; text-align: left; text-transform: none; letter-spacing: normal; word-spacing: normal; word-wrap: normal; white-space: nowrap; float: none; direction: ltr; max-width: none; max-height: none; min-width: 0; min-height: 0; border: 0; padding: 0; margin: 0} .MathJax\_SVG \* {transition: none; -webkit-transition: none; -moz-transition: none; -ms-transition: none; -o-transition: none} .mjx-svg-href {fill: blue; stroke: blue} .MathJax\_SVG\_LineBox {display: table!important} .MathJax\_SVG\_LineBox span {display: table-cell!important; width: 10000em!important; min-width: 0; max-width: none; padding: 0; border: 0; margin: 0}

Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print `Too chaotic` if the state is invalid, i.e. it requires a person to have bribed more than people.

**Sample Input**

.MathJax\_SVG\_Display {text-align: center; margin: 1em 0em; position: relative; display: block!important; text-indent: 0; max-width: none; max-height: none; min-width: 0; min-height: 0; width: 100%} .MathJax\_SVG .MJX-monospace {font-family: monospace} .MathJax\_SVG .MJX-sans-serif {font-family: sans-serif} .MathJax\_SVG {display: inline; font-style: normal; font-weight: normal; line-height: normal; font-size: 100%; font-size-adjust: none; text-indent: 0; text-align: left; text-transform: none; letter-spacing: normal; word-spacing: normal; word-wrap: normal; white-space: nowrap; float: none; direction: ltr; max-width: none; max-height: none; min-width: 0; min-height: 0; border: 0; padding: 0; margin: 0} .MathJax\_SVG \* {transition: none; -webkit-transition: none; -moz-transition: none; -ms-transition: none; -o-transition: none} .mjx-svg-href {fill: blue; stroke: blue}

    2
    5
    2 1 5 3 4
    5
    2 5 1 3 4
    

**Sample Output**

.MathJax\_SVG\_Display {text-align: center; margin: 1em 0em; position: relative; display: block!important; text-indent: 0; max-width: none; max-height: none; min-width: 0; min-height: 0; width: 100%} .MathJax\_SVG .MJX-monospace {font-family: monospace} .MathJax\_SVG .MJX-sans-serif {font-family: sans-serif} .MathJax\_SVG {display: inline; font-style: normal; font-weight: normal; line-height: normal; font-size: 100%; font-size-adjust: none; text-indent: 0; text-align: left; text-transform: none; letter-spacing: normal; word-spacing: normal; word-wrap: normal; white-space: nowrap; float: none; direction: ltr; max-width: none; max-height: none; min-width: 0; min-height: 0; border: 0; padding: 0; margin: 0} .MathJax\_SVG \* {transition: none; -webkit-transition: none; -moz-transition: none; -ms-transition: none; -o-transition: none} .mjx-svg-href {fill: blue; stroke: blue}

    3
    Too chaotic
    

**Explanation**

.MathJax\_SVG\_Display {text-align: center; margin: 1em 0em; position: relative; display: block!important; text-indent: 0; max-width: none; max-height: none; min-width: 0; min-height: 0; width: 100%} .MathJax\_SVG .MJX-monospace {font-family: monospace} .MathJax\_SVG .MJX-sans-serif {font-family: sans-serif} .MathJax\_SVG {display: inline; font-style: normal; font-weight: normal; line-height: normal; font-size: 100%; font-size-adjust: none; text-indent: 0; text-align: left; text-transform: none; letter-spacing: normal; word-spacing: normal; word-wrap: normal; white-space: nowrap; float: none; direction: ltr; max-width: none; max-height: none; min-width: 0; min-height: 0; border: 0; padding: 0; margin: 0} .MathJax\_SVG \* {transition: none; -webkit-transition: none; -moz-transition: none; -ms-transition: none; -o-transition: none} .mjx-svg-href {fill: blue; stroke: blue} .MathJax\_SVG\_LineBox {display: table!important} .MathJax\_SVG\_LineBox span {display: table-cell!important; width: 10000em!important; min-width: 0; max-width: none; padding: 0; border: 0; margin: 0}

**Test Case 1**

The initial state:

![](https://s3.amazonaws.com/hr-challenge-images/494/1451665589-31d436ba19-pic11.png "pic1(1).png")

After person moves one position ahead by bribing person :

![](https://s3.amazonaws.com/hr-challenge-images/494/1451665679-6504422ed9-pic2.png "pic2.png")

Now person moves another position ahead by bribing person :

![](https://s3.amazonaws.com/hr-challenge-images/494/1451665818-27bd62bb0d-pic3.png "pic3.png")

And person moves one position ahead by bribing person :

![](https://s3.amazonaws.com/hr-challenge-images/494/1451666025-02a2395a00-pic5.png "pic5.png")

So the final state is after three bribing operations.

**Test Case 2**

No person can bribe more than two people, so its not possible to achieve the input state.