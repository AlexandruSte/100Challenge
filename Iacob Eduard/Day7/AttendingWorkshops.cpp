/*A student signed up for n workshops and wants to attend the maximum number of workshops where no two workshops overlap. 
You must do the following:
Implement 2 structures:
1. struct Workshop having the following members:
    The workshop's start time.
    The workshop's duration.
    The workshop's end time.
2. struct Available_Workshops having the following members:
    An integer, n(the number of workshops the student signed up for).
    An array of type Workshop array having size n.

Implemen 2 functions:
1. Available_Workshops* initialize (int start_time[], int duration[], int n) 
    Creates an Available_Workshops object and initializes its elements using the elements in the 
    start_time[] and duration[] parameters(both are of size n). Here, start_time[i] and duration[i]
    are the respective start time and duration for the i-th workshop. This function must return a pointer to an Available_Workshops object.
2. int CalculateMaxWorkshops(Available_Workshops* ptr) 
    Returns the maximum number of workshops the student can attend—without overlap. 
    The next workshop cannot be attended until the previous workshop ends
*/
#include<iostream>
#include<algorithm>

using namespace std;

struct Workshop {
	int start_time, duration, end_time;
};

struct Available_Workshops {
	int n;
	Workshop* arr = new Workshop[n];
};


Available_Workshops* initialize(int start_time[], int duration[], int n) {
	Available_Workshops* ptr = new Available_Workshops();
	ptr->n = n;
	for (int i = 0; i < n; i++) {
		Workshop w;
		w.start_time = start_time[i];
		w.end_time = start_time[i] + duration[i];
		w.duration = duration[i];
		ptr->arr[i] = w;
	}
	return ptr;
}

int CalculateMaxWorkshops(Available_Workshops* ptr) {
	int max = 1, nr_w = ptr->n;
	Workshop* w = ptr->arr;
	sort(w, w+nr_w);
	Workshop prev = w[0];
	for (int i = 1; i < nr_w; i++) {
		Workshop curr = w[i];
		if (curr.start_time >= prev.end_time) {
			max++;
			prev = curr;
		}
	}
	return max;
}


bool operator < (Workshop const& a, Workshop const& b) {
	return a.end_time < b.end_time;
}


int main(int argc, char* argv[]) {
	int n; // number of workshops
	cin >> n;
	// create arrays of unknown size n
	int* start_time = new int[n];
	int* duration = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> start_time[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> duration[i];
	}
	Available_Workshops* ptr;
	ptr = initialize(start_time, duration, n);
	cout << CalculateMaxWorkshops(ptr) << endl;
	return 0;
}

/* Input :
6
1 3 0 5 5 8
1 1 6 2 4 1
Output:
4
*/
