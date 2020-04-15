// OpenCVApplication.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <queue>
#include "common.h"
#include <random>
#include <fstream>
const int ERR = 0.12;
int centruR = 0, centruC = 0, arie = 0, p = 0;
float thinness = 0, elon = 0;
Mat_<Vec3b> u;
int rows[] = { -1, 1, 0, 0 };
int cols[] = { 0, 0, -1, 1 };


/* **** LABORATOR 7 **** */

void dilatareHelper(Mat_<Vec3b> img, Mat_<Vec3b>* dest) {
	int w = img.cols;
	int h = img.rows;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			if (img(i, j) == Vec3b(0, 0, 0)) {
				for (int k = 0; k < 5; k++) {
					int ii = i + rows[k];
					int jj = j + cols[k];
					if(ii >= 0 && ii < h && jj >= 0 && jj < w)
						(*dest)(ii, jj) = Vec3b(0, 0, 0);
				}
			}
			else
				(*dest)(i, j) = Vec3b(255, 255, 255);
		}
	}
}

void dilatare() {
	Mat_<Vec3b> img, dest;
	char file[MAX_PATH];
	printf("Numarul de rulari: ");
	int x = 0;
	scanf("%d", &x);
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);
		dest = Mat(img.rows, img.cols, CV_8UC3);
		Mat_<Vec3b> src = Mat(img.rows, img.cols, CV_8UC3);
		img.copyTo(src);

		dilatareHelper(src, &dest);
		for (int i = 0; i < x - 1; i++) {
			dest.copyTo(src);
			dilatareHelper(src, &dest);
		}

		imshow("Source", img);
		imshow("Dilatare", dest);
		waitKey(0);
	}
}


void eroziuneHelper(Mat_<Vec3b> img, Mat_<Vec3b>* dest) {
	int h = img.rows;
	int w = img.cols;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			int ok = 1;
			for (int k = 0; k < 4; k++) {
				int ii = i + rows[k];
				int jj = j + cols[k];
				if (ii < 0 || ii >= h || jj < 0 || jj >= w) {
					(*dest)(i, j) = Vec3b(255, 255, 255);
					ok = 0;
					break;
				}
				else {
					if (img(ii, jj) == Vec3b(255, 255, 255)) {
						(*dest)(i, j) = Vec3b(255, 255, 255);
						ok = 0;
						break;
					}
				}
			}
			if (ok == 1)
				(*dest)(i, j) = Vec3b(0, 0, 0);
		}
	}
}

void eroziune() {
	Mat_<Vec3b> img, dest;
	char file[MAX_PATH];

	int x = 0;
	printf("Numarul de rulari: ");
	scanf("%d", &x);

	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);
		dest = Mat(img.rows, img.cols, CV_8UC3);
		Mat_<Vec3b> src = Mat(img.rows, img.cols, CV_8UC3);
		img.copyTo(src);

		eroziuneHelper(src, &dest);
		for (int i = 0; i < x - 1; i++) {
			dest.copyTo(src);
			eroziuneHelper(src, &dest);
		}

		imshow("Source", img);
		imshow("Eroziune", dest);
		waitKey(0);
	}
}


void deschidereHelper(Mat_<Vec3b> src, Mat_<Vec3b>* dest) {
	Mat_<Vec3b> aux = Mat(src.rows, src.cols, CV_8UC3);
	dest->copyTo(aux);
	eroziuneHelper(src, &aux);
	dilatareHelper(aux, dest);
}

void deschidere() {
	Mat_<Vec3b> img, dest;
	char file[MAX_PATH];
	int x = 0;
	printf("Numarul de rulari: ");
	scanf("%d", &x);

	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);
		dest = Mat(img.rows, img.cols, CV_8UC3);
		Mat_<Vec3b> src = Mat(img.rows, img.cols, CV_8UC3);
		img.copyTo(src);

		deschidereHelper(src, &dest);
		for (int i = 0; i < x - 1; i++) {
			dest.copyTo(src);
			deschidereHelper(src, &dest);
		}

		imshow("Sursa", img);
		imshow("Deschidere", dest);
		waitKey(0);
	}
}


void AND(Mat_<Vec3b> A, Mat_<Vec3b> B, Mat_<Vec3b> *C) {
	*C = Mat(A.rows, A.cols, CV_8UC3);
	for (int i = 0; i < A.rows; i++) {
		for (int j = 0; j < A.rows; j++) {
			if (A(i, j) == Vec3b(0, 0, 0) && B(i, j) == Vec3b(0, 0, 0))
				(*C)(i, j) = Vec3b(0, 0, 0);
			else
				(*C)(i, j) = Vec3b(255, 255, 255);
		}
	}
}

void OR(Mat_<Vec3b> A, Mat_<Vec3b> B, Mat_<Vec3b>* C) {
	*C = Mat(A.rows, A.cols, CV_8UC3);
	for (int i = 0; i < A.rows; i++) {
		for (int j = 0; j < A.rows; j++) {
			if (A(i, j) == Vec3b(0, 0, 0) && A(i, j) == Vec3b(0, 0, 0))
				(*C)(i, j) = Vec3b(0, 0, 0);
			else
				(*C)(i, j) = Vec3b(255, 255, 255);
		}
	}
}

void NOT(Mat_<Vec3b> A, Mat_<Vec3b>* C) {
	*C = Mat(A.rows, A.cols, CV_8UC3);
	for (int i = 0; i < A.rows; i++) {
		for (int j = 0; j < A.rows; j++) {
			if (A(i, j) != Vec3b(0, 0, 0))
				(*C)(i, j) = Vec3b(0, 0, 0);
			else
				(*C)(i, j) = Vec3b(255, 255, 255);
		}
	}
}

void DIF(Mat_<Vec3b> A, Mat_<Vec3b> B, Mat_<Vec3b>* C) {
	Mat_<Vec3b> notB = Mat(B.rows, B.cols, CV_8UC3);
	NOT(B, &notB);
	AND(notB, A, C);
}


void inchidereHelper(Mat_<Vec3b> src, Mat_<Vec3b>* dest) {
	Mat_<Vec3b> aux = Mat(src.rows, src.cols, CV_8UC3);
	dest->copyTo(aux);
	dilatareHelper(src, &aux);
	eroziuneHelper(aux, dest);
}

void inchidere() {
	Mat_<Vec3b> img, dest;
	char file[MAX_PATH];
	int x = 0;
	printf("Numarul de rulari: ");
	scanf("%d", &x);

	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);
		dest = Mat(img.rows, img.cols, CV_8UC3);

		Mat_<Vec3b> src = Mat(img.rows, img.cols, CV_8UC3);
		img.copyTo(src);
		inchidereHelper(src, &dest);
		for (int i = 0; i < x - 1; i++) {
			dest.copyTo(src);
			inchidereHelper(src, &dest);
		}



		imshow("Sursa", img);
		imshow("Deschidere", dest);
		waitKey(0);
	}
}

void extragereContur() {
	
	Mat_<Vec3b> img, dest, contur;
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);
		dest = Mat(img.rows, img.cols, CV_8UC3);
		contur = Mat(img.rows, img.cols, CV_8UC3);

		eroziuneHelper(img, &dest);
		DIF(img, dest, &contur);

		imshow("source", img);
		imshow("contur", contur);
		waitKey(0);

	}
}



/* **** LABORATOR 6 **** */
// 1 si 2

void urmarireContur() {
	int rows[] = { 0, -1, -1, -1,  0,  1, 1, 1 };
	int cols[] = { 1,  1,  0, -1, -1, -1, 0, 1 };
	char filename[MAX_PATH];
	Mat_<Vec3b> imgDest;
	Mat_<Vec3b> img;
	
	std::vector<int> directions;

	while (openFileDlg(filename)) {
		img = imread(filename, CV_LOAD_IMAGE_COLOR);
		
		int height = img.rows;
		int width = img.cols;
		imgDest = Mat(height, width, CV_8UC3);

		Mat_<uchar> binaryImage = Mat(height, width, CV_8UC1);

		boolean first = true;
		Point p0 = Point(0, 0);
		for (int i = 0; i < height; i++) {
			for (int j = 0;  j < width; j++) {
				imgDest(i, j) = Vec3b(0, 0, 0);
				if (img(i, j) == Vec3b(0, 0, 0)) {
					binaryImage(i, j) = 1;
					if (first) {
						// Alegem pixelul de start P0
						p0 = Point(i, j);
						first = false;
					}
				}
			}
		}

		int dir = 7;
		int index = 0;
		Point current = p0;
		Point p1 = (0, 0);
		first = true;
		while (true) {
			if (current == p0 && !first)
				break;
			first = false;
			//setam in imaginea de destinatie pixelul curent
			imgDest(current.x, current.y) = Vec3b(255, 255, 255);
			int posIndex = dir % 2 == 0 ? (dir + 7) % 8 : (dir + 6) % 8;
			while (binaryImage(current.x, current.y) != binaryImage(current.x + rows[posIndex], current.y + cols[posIndex])) {
				if (posIndex == 7)
					posIndex = 0;
				else
					posIndex++;
			}
			directions.push_back(posIndex);
			current.x += rows[posIndex];
			current.y += cols[posIndex];
			if (directions.size() == 1)
				p1 = current;
			else if (p1 == current)
				break;
			//actualizam DIR
			dir = posIndex;
		}

		// AFISARE CODURI INLANTUITE
		printf("Cod: ");
		for (int i : directions) {
			printf("%d ", i);
		}

		printf("\n\nDerivata: ");
		for (int i = 0; i < directions.size() - 1; i++) {
			int der = (directions.at(i+1) - directions.at(i)) + 8;
			der = der % 8;
			printf("%d ", der);
		}


		imshow("Contur", imgDest);
		imshow("Source", img);
		waitKey(0);
	}
}

void construireContur() {
	int rows[] = { 0, -1, -1, -1,  0,  1, 1, 1 };
	int cols[] = { 1,  1,  0, -1, -1, -1, 0, 1 };
	Mat_<Vec3b> img;
	FILE* file;
	file = fopen("reconstruct.txt", "r");
	if (file == NULL)
		printf("File open file\n");
	else {
		int x, y;
		int dirs;
		fscanf(file, "%d", &x);
		fscanf(file, "%d", &y);
		fscanf(file, "%d", &dirs);

		img = imread("Images/gray_background.bmp", CV_LOAD_IMAGE_COLOR);

		img(x, y) = Vec3b(0, 0, 255);
		int index = 0, dir;
		while (index < dirs) {
			fscanf(file, "%d", &dir);
			
			//int pos = dir % 2 != 0 ? (dir + 6) % 8 : (dir + 7) % 8;
			x += rows[dir];
			y += cols[dir];
			img(x, y) = Vec3b(0, 0, 255);
			index++;
		}
	}

	imshow("img", img);
	waitKey(0);
}
/* **** LABORATOR 5 **** */

Mat_<uchar> bfs(Mat_<uchar> u, int nrVecini = 8) {
	imshow("Originala", u);
	std::default_random_engine gen;
	std::uniform_int_distribution<int> d(0, 255);
	int h = u.rows;
	int w = u.cols;

	int label = 0;
	Mat_<uchar> labels = Mat::zeros(h, w, CV_8UC1);
	Mat_<Vec3b> colorImg = Mat(h, w, CV_8UC3);

	int di[] = {-1, 0, 1, 0, -1, 1, 1, -1};
	int dj[] = {0, -1, 0, 1, 1, -1, 1, -1};

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			if (u(i, j) == 0 && labels(i, j) == 0) {
				label++;
				std::queue<Point> Q;
				labels(i, j) = label;
				Q.push({ i, j });

				uchar r = d(gen);
				uchar g = d(gen);
				uchar b = d(gen);
				Vec3b color = Vec3b(b, g, r);

				while (!Q.empty()) {
					Point qq = Q.front(); Q.pop();
					colorImg(qq.x, qq.y) = color;

					for (int k = 0; k < nrVecini; k++) {
						int xi = qq.x + di[k];
						int xj = qq.y + dj[k];
						if (u(xi, xj) == 0 && labels(xi, xj) == 0) {
							labels(xi, xj) = label;
							Q.push({ xi, xj });
						}
					}
				}
			}
		}
	}

	//imshow("Labels", labels);
	//imshow("Color img", colorImg);
	//waitKey(0);

	return labels;
}

int minValue(std::vector<int> L) {
	int min = 9999;
	for (int i : L) {
		if (i < min)
			min = i;
	}
	return min;
}

void conexComponents(Mat_<uchar> mat, int nrVecini) {
	int label = 0;
	int h = mat.rows;
	int w = mat.cols;

	Mat_<uchar> labels = Mat::zeros(h, w, CV_8UC1);
	std::vector<std::vector<int>> edges;

	int di[] = { -1, 0, 1, 0, -1, 1, 1, -1 };
	int dj[] = { 0, -1, 0, 1, 1, -1, 1, -1 };
	
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			if (mat(i, j) == 0 && labels(i, j) == 0) {
				std::vector<int> L;
				for (int k = 0; k < nrVecini; k++) {
					int xi = i + di[k];
					int yi = j + dj[k];
					if (labels[xi][yi] > 0) {
						L.push_back(labels[xi][yi]);
					}
				}
				if (L.size() == 0) {
					label++;
					labels(i, j) = label;
				} else {
					int x = minValue(L);
					labels(i, j) = x;
					for (int y : L) {
						if (y != x) {
							edges.resize(label + 1);
							edges[x].push_back(y);
							edges[y].push_back(x);
						}
					}
				}
			}
		}
	}

	int newLabel = 0;
	std::vector<int> newLabels(label + 1, 0);
	for (int i = 1; i <= label; i++) {
		if (newLabels[i] == 0) {
			newLabel++;
			std::queue<int> Q;
			newLabels[i] = newLabel;
			Q.push(i);
			while (!Q.empty()) {
				int x = Q.front(); Q.pop();
				for (int y : edges[x]) {
					if (newLabels[y] == 0) {
						newLabels[y] = newLabel;
						Q.push(y);
					}
				}
			}
		}
	}

	imshow("Prima parcurgere", labels);

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			labels(i, j) = newLabels[labels(i, j)];
		}
	}

	imshow("A doua parcurgere", labels);
	waitKey(0);
}

void algoritm1() {
	Mat_<uchar> u;
	char filename[MAX_PATH];
	while (openFileDlg(filename)) {
		u = imread(filename, CV_LOAD_IMAGE_ANYCOLOR);
		int nrVecini = 8;
		bfs(u, nrVecini);
	}
}

void algoritm2() {
	Mat_<uchar> img;
	char filename[MAX_PATH];
	while (openFileDlg(filename)) {
		img = imread(filename, CV_LOAD_IMAGE_ANYCOLOR);
		int nrVecini = 8;
		conexComponents(img, nrVecini);
	}
}

/* **** LABORATOR 4 **** */
//aria
//centrul de masa
//axa de alungire
//perimetrul
//factorul de subtiere
//elongatia (factorul de aspect)


void aria(Mat_<uchar> I) {
	arie = 0;
	for (int i = 0; i < I.rows; i++) {
		for (int j = 0; j < I.cols; j++) {
			arie += I(i, j);
		}
	}
}

void centrulMasa(Mat_<uchar> I) {
	int r = 0, c = 0;
	for (int i = 0; i < I.rows; i++) {
		for (int j = 0; j < I.cols; j++) {
			//printf("%d ", I(i, j));
			r += i * I(i, j);
			c += j * I(i, j);
		}
	}

	r = r / arie;
	c = c / arie;

	centruR = r;
	centruC = c;
}

void axaAlungire(Mat_<uchar> I) {
	float axa = 0;
	float r = 0, c = 0;

	int aux = 0;
	int aux1 = 0, aux2 = 0;
	for (int i = 0; i < I.rows; i++) {
		for (int j = 0; j < I.cols; j++) {
			aux += (r - i) * (c - j) * I(i, j);

			aux1 += (c - j) * (c - j) * I(i, j);
			aux2 += (r - i) * (r - i) * I(i, j);
		}
	}
	aux = 2 * aux;
	axa = atan2(aux, (aux1 - aux2));
	float phi = 1 / (float)2 * axa;
	phi = phi * (180 / PI);
	if (phi < 0) phi += 180;
	printf("Axa de alungire este %f \n", phi);

	float phiRad = phi * CV_PI / 180.0f;
	int rA = centruR - tan(phiRad) * centruC;
	int cA = 0;
	int rB = centruR + tan(phiRad) * (I.cols - centruC);
	int cB = I.cols;
	Point centru(cA, rA);
	Point otherpoint(cB, rB);

	line(u, centru, otherpoint, CV_RGB(255, 0, 0), 1);

}

void perimetru(Mat_<uchar> I) {
	p = 0;
	for (int i = 0; i < I.rows; i++) {
		for (int j = 0; j < I.cols; j++) {
			if (I(i, j) == 1) {
				if (I(i + 1, j) == 0 || I(i, j + 1) == 0 ||
					I(i - 1, j) == 0 || I(i, j - 1) == 0 ||
					I(i + 1, j + 1) == 0 || I(i - 1, j - 1) == 0 ||
					I(i - 1, j + 1) == 0 || I(i + 1, j - 1) == 0)

					u(i, j) = Vec3b(255, 0, 0);
					p += 1;
			}
		}
	}

	for (int i = centruR - 2; i <= centruR + 2; i++) {
		for (int j = centruC - 2; j <= centruC + 2; j++) {
			u(i, j) = Vec3b(0, 0, 255);
		}
	}
	

}

void factorSubtiere(Mat_<uchar> I) {
	thinness = 4 * PI * ((float)arie / (p * p));
}

void elongatie(Mat_<uchar> I) {
	//elon = 90;
}

void proiectie(Mat_<uchar> I) {
	std::vector<int> h, v;
	int sumR = 0;
	int sumC = 0;
	for (int i = 0; i < I.rows; i++) {
		sumR = 0;
		for (int j = 0; j < I.cols; j++) {
			sumR += I(i, j);
			//u(i, sumR) = I(i, j);
			//sumR++;
		}
		h.at(i) = sumR;
	}

	for (int i = 0; i < I.cols; i++) {
		sumC = I.rows - 1;
		for (int j = 0; j < I.rows; j++) {
			sumC += I(j, i);
			//u(sumC, i) = I(j, i);
			//sumC--;
		}
		v.at(i) = sumC;
	}
}

Mat_<uchar> getI(Mat_<uchar> img, uchar a) {
	int h = img.rows;
	int c = img.cols;
	Mat_<uchar> I = Mat(h, c, CV_8UC1);
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < c; j++) {
			if (img(i, j) == a)
				I(i, j) = 1;
			else
				I(i, j) = 0;
		}
	}
	return I;
}

void calc_I(Mat_<uchar> img, uchar a) {
	Mat_<uchar> I = getI(img, a);

	aria(I);
	centrulMasa(I);
	perimetru(I);
	factorSubtiere(I);
	axaAlungire(I);
	elongatie(I);
	//proiectie(I);
	

	printf("Aria obiectului din imagine este: %d\n", arie);
	printf("Perimetrul obiectului selectat este %d \n", p);
	printf("Centrul de masa are coordonatele (%d, %d) \n", centruR, centruC);
	printf("Factorul de subtiere %f \n", thinness);

	imshow("Contur", u);
	waitKey(0);

}


/* **** LABORATOR 3 **** */

void showHistogram(const std::string& name, int* hist, const int  hist_cols, const int hist_height)
{
	Mat imgHist(hist_height, hist_cols, CV_8UC3, CV_RGB(255, 255, 255)); // constructs a white image

	//computes histogram maximum
	int max_hist = 0;
	for (int i = 0; i < hist_cols; i++)
		if (hist[i] > max_hist)
			max_hist = hist[i];
	double scale = 1.0;
	scale = (double)hist_height / max_hist;
	int baseline = hist_height - 1;

	for (int x = 0; x < hist_cols; x++) {
		Point p1 = Point(x, baseline);
		Point p2 = Point(x, baseline - cvRound(hist[x] * scale));
		line(imgHist, p1, p2, CV_RGB(255, 0, 255)); // histogram bins colored in magenta
	}

	imshow(name, imgHist);
}

std::vector<int> getHistogram(Mat_<uchar> img) {
	std::vector <int> v(256);
	for (int i = 0; i < img.rows; i++) {
		for (int j = 0; j < img.cols; j++) {
			int aux = img(i, j);
			v[aux]++;
		}
	}
	return v;
}

void calculateHistogram() {
	std::vector <int> v(256);
	Mat_<uchar> img;
	char filename[MAX_PATH];
	while (openFileDlg(filename)) {
		img = imread(filename, CV_LOAD_IMAGE_GRAYSCALE);
		v = getHistogram(img);
		showHistogram("HistogramaCalculata", v.data(), img.cols, img.rows);
		waitKey(0);
	}
}

std::vector<float> fdp(Mat_<uchar> img) {
	int M = img.rows * img.cols;
	std::vector<int> v(256, 0);
	v = getHistogram(img);
	std::vector<float> f(256, 0);
	for (int i = 0; i < 256; i++) {
		f.at(i) = (float)v.at(i) / M;
	}

	return f;

}
void calculateFDP() {
	std::vector<int> v(256, 0);
	std::vector<float> fdp(256, 0);
	int M;
	Mat_<uchar> img;
	char filename[MAX_PATH];
	while (openFileDlg(filename)) {
		img = imread(filename, CV_LOAD_IMAGE_GRAYSCALE);
		M = img.rows * img.cols;

		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				float aux = (float)img(i, j);
				v[aux]++;
			}
		}

		for (int i = 0; i < 256; i++) {
			fdp[i] = (float)v[i] / M;
		}

	}
}

void praguriMultiple() {
	Mat_<uchar> img;
	char filename[MAX_PATH];

	while (openFileDlg(filename)) {
		img = imread(filename, CV_LOAD_IMAGE_GRAYSCALE);	
		std::vector<int> v(256, 0);
		std::vector<float> FDP(256, 0);
		std::vector<float> maxime;
		int M = img.rows * img.cols;

		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				v.at(img(i, j)) += 1;
			}
		}
		showHistogram("Histograma", v.data(), img.rows, img.cols);
		
		//fdp
		for (int i = 0; i < 256; i++) {
			FDP.at(i) = (float)v[i] / M;
		}
		//suprapunerea
		int WH = 5;
		int width = 2 * WH + 1;
		float TH = 0.0003;
		for (int k = 0 + WH; k <= 255 - WH; k++) {
			float mediaV = 0;
			float aux = FDP[k];
			bool maxim = true;
			//calculez media si verific daca f[i] e maxim
			for (int j = k - WH; j <= k + WH; j++) {
				mediaV += FDP.at(j);
				if (FDP.at(k) < FDP.at(j))
					maxim = false;
			}
			mediaV = (float) mediaV / width;
			if (FDP[k] > mediaV + TH) {
				if (maxim == true) {
					maxime.push_back(k);
					//printf("Maxim %d\n", k);
				}
			}
		}
		maxime.insert(maxime.begin(), 1, 0);
		maxime.insert(maxime.end(), 1, 255);

		//for (int i = 0; i < maxime.size(); i++) {
		//	printf("%f ", maxime[i]);
		//}

		//find closest maxim
		Mat_<uchar> reduced = Mat(img.rows, img.cols, CV_8UC1);

		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				int color = img(i, j);
				float close = 255;
				float maximPoint = maxime[0];
				for (int k = 0; k < maxime.size(); k++) {
					if (abs(color - maxime[k]) <= close) {
						close = abs(color - maxime[k]);
						maximPoint = maxime[k];
					}
				}
				reduced(i, j) = maximPoint;
			}
		}

		imshow("Initial image", img);
		imshow("M", reduced);
		waitKey(0);
	}
}


void testOpenImage()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		Mat src;
		src = imread(fname);
		imshow("image",src);	
		waitKey();
	}
}

void testOpenImagesFld()
{
	char folderName[MAX_PATH];
	if (openFolderDlg(folderName)==0)
		return;
	char fname[MAX_PATH];
	FileGetter fg(folderName,"bmp");
	while(fg.getNextAbsFile(fname))
	{
		Mat src;
		src = imread(fname);
		imshow(fg.getFoundFileName(),src);
		if (waitKey()==27) //ESC pressed
			break;
	}
}

void testImageOpenAndSave()
{
	Mat src, dst;

	src = imread("Images/Lena_24bits.bmp", CV_LOAD_IMAGE_COLOR);	// Read the image

	if (!src.data)	// Check for invalid input
	{
		printf("Could not open or find the image\n");
		return;
	}

	// Get the image resolution
	Size src_size = Size(src.cols, src.rows);

	// Display window
	const char* WIN_SRC = "Src"; //window for the source image
	namedWindow(WIN_SRC, CV_WINDOW_AUTOSIZE);
	cvMoveWindow(WIN_SRC, 0, 0);

	const char* WIN_DST = "Dst"; //window for the destination (processed) image
	namedWindow(WIN_DST, CV_WINDOW_AUTOSIZE);
	cvMoveWindow(WIN_DST, src_size.width + 10, 0);

	cvtColor(src, dst, CV_BGR2GRAY); //converts the source image to a grayscale one

	imwrite("Images/Lena_24bits_gray.bmp", dst); //writes the destination to file

	imshow(WIN_SRC, src);
	imshow(WIN_DST, dst);

	printf("Press any key to continue ...\n");
	waitKey(0);
}

void testNegativeImage()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		double t = (double)getTickCount(); // Get the current time [s]
		
		Mat src = imread(fname,CV_LOAD_IMAGE_GRAYSCALE);
		int height = src.rows;
		int width = src.cols;
		Mat dst = Mat(height,width,CV_8UC1);
		// Asa se acceseaaza pixelii individuali pt. o imagine cu 8 biti/pixel
		// Varianta ineficienta (lenta)
		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				uchar val = src.at<uchar>(i,j);
				uchar neg = MAX_PATH-val;
				dst.at<uchar>(i,j) = neg;
			}
		}

		// Get the current time again and compute the time difference [s]
		t = ((double)getTickCount() - t) / getTickFrequency();
		// Print (in the console window) the processing time in [ms] 
		printf("Time = %.3f [ms]\n", t * 1000);

		imshow("input image",src);
		imshow("negative image",dst);
		waitKey();
	}
}

void testParcurgereSimplaDiblookStyle()
{
	char fname[MAX_PATH];
	while (openFileDlg(fname))
	{
		Mat src = imread(fname, CV_LOAD_IMAGE_GRAYSCALE);
		int height = src.rows;
		int width = src.cols;
		Mat dst = src.clone();

		double t = (double)getTickCount(); // Get the current time [s]

		// the fastest approach using the “diblook style”
		uchar *lpSrc = src.data;
		uchar *lpDst = dst.data;
		int w = (int) src.step; // no dword alignment is done !!!
		for (int i = 0; i<height; i++)
			for (int j = 0; j < width; j++) {
				uchar val = lpSrc[i*w + j];
				lpDst[i*w + j] = 255 - val;
			}

		// Get the current time again and compute the time difference [s]
		t = ((double)getTickCount() - t) / getTickFrequency();
		// Print (in the console window) the processing time in [ms] 
		printf("Time = %.3f [ms]\n", t * 1000);

		imshow("input image",src);
		imshow("negative image",dst);
		waitKey();
	}
}

void testColor2Gray()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		Mat src = imread(fname);

		int height = src.rows;
		int width = src.cols;

		Mat dst = Mat(height,width,CV_8UC1);

		// Asa se acceseaaza pixelii individuali pt. o imagine RGB 24 biti/pixel
		// Varianta ineficienta (lenta)
		for (int i=0; i<height; i++)
		{
			for (int j=0; j<width; j++)
			{
				Vec3b v3 = src.at<Vec3b>(i,j);
				uchar b = v3[0];
				uchar g = v3[1];
				uchar r = v3[2];
				dst.at<uchar>(i,j) = (r+g+b)/3;
			}
		}
		
		imshow("input image",src);
		imshow("gray image",dst);
		waitKey();
	}
}

void testBGR2HSV()
{
	char fname[MAX_PATH];
	while (openFileDlg(fname))
	{
		Mat src = imread(fname);
		int height = src.rows;
		int width = src.cols;

		// Componentele d eculoare ale modelului HSV
		Mat H = Mat(height, width, CV_8UC1);
		Mat S = Mat(height, width, CV_8UC1);
		Mat V = Mat(height, width, CV_8UC1);

		// definire pointeri la matricele (8 biti/pixeli) folosite la afisarea componentelor individuale H,S,V
		uchar* lpH = H.data;
		uchar* lpS = S.data;
		uchar* lpV = V.data;

		Mat hsvImg;
		cvtColor(src, hsvImg, CV_BGR2HSV);

		// definire pointer la matricea (24 biti/pixeli) a imaginii HSV
		uchar* hsvDataPtr = hsvImg.data;

		for (int i = 0; i<height; i++)
		{
			for (int j = 0; j<width; j++)
			{
				int hi = i*width * 3 + j * 3;
				int gi = i*width + j;

				lpH[gi] = hsvDataPtr[hi] * 510 / 360;		// lpH = 0 .. 255
				lpS[gi] = hsvDataPtr[hi + 1];			// lpS = 0 .. 255
				lpV[gi] = hsvDataPtr[hi + 2];			// lpV = 0 .. 255
			}
		}

		imshow("input image", src);
		imshow("H", H);
		imshow("S", S);
		imshow("V", V);

		waitKey();
	}
}

void testResize()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		Mat src;
		src = imread(fname);
		Mat dst1,dst2;
		//without interpolation
		resizeImg(src,dst1,320,false);
		//with interpolation
		resizeImg(src,dst2,320,true);
		imshow("input image",src);
		imshow("resized image (without interpolation)",dst1);
		imshow("resized image (with interpolation)",dst2);
		waitKey();
	}
}

void testCanny()
{
	char fname[MAX_PATH];
	while(openFileDlg(fname))
	{
		Mat src,dst,gauss;
		src = imread(fname,CV_LOAD_IMAGE_GRAYSCALE);
		double k = 0.4;
		int pH = 50;
		int pL = (int) k*pH;
		GaussianBlur(src, gauss, Size(5, 5), 0.8, 0.8);
		Canny(gauss,dst,pL,pH,3);
		imshow("input image",src);
		imshow("canny",dst);
		waitKey();
	}
}

void testVideoSequence()
{
	VideoCapture cap("Videos/rubic.avi"); // off-line video from file
	//VideoCapture cap(0);	// live video from web cam
	if (!cap.isOpened()) {
		printf("Cannot open video capture device.\n");
		waitKey(0);
		return;
	}
		
	Mat edges;
	Mat frame;
	char c;

	while (cap.read(frame))
	{
		Mat grayFrame;
		cvtColor(frame, grayFrame, CV_BGR2GRAY);
		Canny(grayFrame,edges,40,100,3);
		imshow("source", frame);
		imshow("gray", grayFrame);
		imshow("edges", edges);
		c = cvWaitKey(0);  // waits a key press to advance to the next frame
		if (c == 27) {
			// press ESC to exit
			printf("ESC pressed - capture finished\n"); 
			break;  //ESC pressed
		};
	}
}

void testSnap()
{
	VideoCapture cap(0); // open the deafult camera (i.e. the built in web cam)
	if (!cap.isOpened()) // openenig the video device failed
	{
		printf("Cannot open video capture device.\n");
		return;
	}

	Mat frame;
	char numberStr[256];
	char fileName[256];
	
	// video resolution
	Size capS = Size((int)cap.get(CV_CAP_PROP_FRAME_WIDTH),
		(int)cap.get(CV_CAP_PROP_FRAME_HEIGHT));

	// Display window
	const char* WIN_SRC = "Src"; //window for the source frame
	namedWindow(WIN_SRC, CV_WINDOW_AUTOSIZE);
	cvMoveWindow(WIN_SRC, 0, 0);

	const char* WIN_DST = "Snapped"; //window for showing the snapped frame
	namedWindow(WIN_DST, CV_WINDOW_AUTOSIZE);
	cvMoveWindow(WIN_DST, capS.width + 10, 0);

	char c;
	int frameNum = -1;
	int frameCount = 0;

	for (;;)
	{
		cap >> frame; // get a new frame from camera
		if (frame.empty())
		{
			printf("End of the video file\n");
			break;
		}

		++frameNum;
		
		imshow(WIN_SRC, frame);

		c = cvWaitKey(10);  // waits a key press to advance to the next frame
		if (c == 27) {
			// press ESC to exit
			printf("ESC pressed - capture finished");
			break;  //ESC pressed
		}
		if (c == 115){ //'s' pressed - snapp the image to a file
			frameCount++;
			fileName[0] = NULL;
			sprintf(numberStr, "%d", frameCount);
			strcat(fileName, "Images/A");
			strcat(fileName, numberStr);
			strcat(fileName, ".bmp");
			bool bSuccess = imwrite(fileName, frame);
			if (!bSuccess) 
			{
				printf("Error writing the snapped image\n");
			}
			else
				imshow(WIN_DST, frame);
		}
	}

}

void MyCallBackFunc(int event, int x, int y, int flags, void* param)
{
	//More examples: http://opencvexamples.blogspot.com/2014/01/detect-mouse-clicks-and-moves-on-image.html
	Mat* src = (Mat*)param;
	if (event == CV_EVENT_LBUTTONDOWN)
		{
			printf("Pos(x,y): %d,%d  Color(RGB): %d,%d,%d\n",
				x, y,
				(int)(*src).at<Vec3b>(y, x)[2],
				(int)(*src).at<Vec3b>(y, x)[1],
				(int)(*src).at<Vec3b>(y, x)[0]);

			uchar color = (uchar)(*src).at<uchar>(y, x);
			calc_I((Mat_<Vec3b>)(*src), color);
		}
}

void testMouseClick()
{
	Mat src;
	// Read image from file 
	char fname[MAX_PATH];
	while (openFileDlg(fname))
	{
		src = imread(fname);
		//Create a window
		namedWindow("My Window", 1);

		//set the callback function for any mouse event
		setMouseCallback("My Window", MyCallBackFunc, &src);

		//show the image
		imshow("My Window", src);

		// Wait until user press some key
		waitKey(0);
	}
}

/* Histogram display function - display a histogram using bars (simlilar to L3 / PI)
Input:
name - destination (output) window name
hist - pointer to the vector containing the histogram values
hist_cols - no. of bins (elements) in the histogram = histogram image width
hist_height - height of the histogram image
Call example:
showHistogram ("MyHist", hist_dir, 255, 200);
*/


void negativeImage() {
	char fileName[MAX_PATH];
	Mat img;
	while (openFileDlg(fileName)) {
		img = imread(fileName, CV_LOAD_IMAGE_GRAYSCALE);

		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				img.at<uchar>(i, j) = 255 - img.at<uchar>(i, j);
			}
		}
		imshow("negative image", img);
		waitKey(0);
	}
	
}

void negativeImage_refactor() {
	char fileName[MAX_PATH];
	Mat_<uchar> img;
	while (openFileDlg(fileName)) {
		img = imread(fileName, CV_LOAD_IMAGE_GRAYSCALE);
		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				img(i, j) = 255 - img(i, j);
			}
		}

		imshow("Negative Image", img);
		waitKey(0);
	}
}

void addToGray() {
	char fileName[MAX_PATH];
	Mat_<uchar> img, img2;
	while (openFileDlg(fileName)) {
		img2 = imread(fileName, CV_LOAD_IMAGE_GRAYSCALE);
		img = imread(fileName, CV_LOAD_IMAGE_GRAYSCALE);

		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				int aux = img(i, j);
				aux += 100;
				if (aux > 255) {
					img(i, j) = 255;
				}
				else
					img(i, j) = aux;
			}
		}
		imshow("Add to Gray", img);
		imshow("Normal Image", img2);
		waitKey(0);
	}
	
}

void multiplyToGray() {
	char fileName[MAX_PATH];
	Mat_<uchar> img, img2;
	while (openFileDlg(fileName)) {
		img = imread(fileName, CV_LOAD_IMAGE_GRAYSCALE);
		
		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				int aux = img(i, j) * 2;
				if (aux > 255) {
					img(i, j) = 255;
				}
				else {
					img(i, j) = aux;
				}
			}
		}

		imshow("Multiply", img);
		imwrite("D:\\Georgian\\UTCN\\An 3\\Sem2\\PI\\Lab01\\Imagini\\addedBrightness.bmp", img);
		
		waitKey(0);
	}
}

void invMat() {
	Mat_<float> M(3, 3);
	M(0, 0) = -4.0;
	M(0, 1) = 2.0;
	M(0, 2) = 1.0;
	M(1, 0) = 5.2;
	M(1, 1) = 6.2;
	M(1, 2) = 2.4;
	M(2, 0) = -2.2;
	M(2, 1) = 1.9;
	M(2, 2) = 7.4;

	Mat_<float> img;
	img = M.inv();

	std::cout << M << std::endl;
	std::cout << img << std::endl;
	while (true);
	waitKey(0);

}

void quattro() {
	Mat_<Vec3b> img(256, 256);

	for (int i = 0; i < 127; i++) {
		for (int j = 0; j < 127; j++) {
			img(i, j) = Vec3b(255, 255, 255);
		}
	}

	for (int i = 128; i < 256; i++) {
		for (int j = 0; j < 127; j++) {
			img(i, j) = Vec3b(0, 0, 255);
		}
	}

	for (int i = 0; i < 127; i++) {
		for (int j = 128; j < 256; j++) {
			img(i, j) = Vec3b(0, 255, 0);
		}
	}

	for (int i = 128; i < 256; i++) {
		for (int j = 128; j < 256; j++) {
			img(i, j) = Vec3b(0, 255, 255);
		}
	}

	imshow("Image", img);
	waitKey(0);
	
}


//lab2
void copyRGB() {
	Mat_<Vec3b> img;
	Mat_<uchar> red, green, blue;
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);

		red = Mat_<uchar>(img.rows, img.cols);
		green = Mat_<uchar>(img.rows, img.cols);
		blue = Mat_<uchar>(img.rows, img.cols);

		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				Vec3b temp = img(i, j);
				red(i, j) = temp[2];
				green(i, j) = temp[1];
				blue(i, j) = temp[0];
			}
		}

		imshow("Red", red);
		imshow("Green", green);
		imshow("Blue", blue);
		waitKey(0);
	}
}

void convertToGrayscale(){
	Mat_<Vec3b> img;
	Mat_<uchar> imgGray;
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);
		imgGray = Mat_<uchar>(img.rows, img.cols);
		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				Vec3b temp = img(i, j);
				imgGray(i, j) = (float)(temp[2] + temp[1] + temp[0]) / 3;
			}
		}


		imshow("Gray", imgGray);
		waitKey(0);
	}
}

void convertToHSV() {
	Mat_<Vec3b> img;
	Mat_<uchar> h, s, v;
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);

		h = Mat_<uchar>(img.rows, img.cols);
		s = Mat_<uchar>(img.rows, img.cols);
		v = Mat_<uchar>(img.rows, img.cols);

		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				Vec3b temp = img(i, j);
				float r = (float)temp[2] / 255;
				float g = (float)temp[1] / 255;
				float b = (float)temp[0] / 255;

				float M = max(max(r, g), b);
				float m = min(min(r, g), b);
				float C = M - m;
				float V = M;
				float S;
				if (V != 0) {
					S = C / V;
				}
				else {
					S = 0;
				}
				float H;
				if (C != 0) {
					if (M == r) H = 60 * (g - b) / C;
					if (M == g) H = 120 + 60 * (b - r) / C;
					if (M == b) H = 240 + 60 * (r - g) / C;
				}
				else {
					H = 0;
				}
				if (H < 0)
					H = H + 360;

				h(i, j) = H * 255 / 360;
				s(i, j) = S * 255;
				v(i, j) = V * 255;
			}
		}

		imshow("Hue", h);
		imshow("Value", v);
		imshow("Saturation", s);
		waitKey(0);
	}
}



/* **** LABORATOR 8 **** */

//functii de transformare a histogramei pt calcului
//negativului imaginii, latirea/ingustarea histogramei
//coretia gamma, luminozitate


//algoritmul de egalizare a histogramei



float getMean(Mat_<uchar> img) {
	float mean = 0.0;
	int M = img.rows * img.cols;
	for (int i = 0; i < img.rows; i++) {
		for (int j = 0; j < img.cols; j++) {
			mean += img(i, j);
		}
	}
	mean = (float)mean / M;

	return mean;
}

void medie() {
	char file[MAX_PATH];
	Mat_<uchar> img;
	int M = 0;
	float mean = 0.0;
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);
		mean = getMean(img);
		printf("Media de intensitate este: %.4f\n", mean);
		//showHistogram("Histograma", v.data(), img.cols, img.rows);
		waitKey(0);
	}
}

void deviatie() {
	char file[MAX_PATH];
	float mean = 0.0;
	float dev = 0.0;
	Mat_<uchar> img;
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_COLOR);
		mean = getMean(img);
		float aux = 0.0;
		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				aux += ((img(i, j) - mean) * (img(i, j) - mean));
			}
		}
		aux = (float)aux / (img.rows * img.cols);
		dev = std::sqrt(aux);
		printf("Media intensitatii este: %.4f\n", mean);
		printf("Deviatia este: %.4f\n", dev);
		waitKey(0);
	}
}

void binarizare() {
	char file[MAX_PATH];
	Mat_<uchar> img;
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_GRAYSCALE);
		std::vector<int> I = getHistogram(img);
		int min = 999999, max = -1;
		int H = img.rows, W = img.cols;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (img(i, j) < min) min = img(i, j);
				if (img(i, j) > max) max = img(i, j);
			}
		}

		float T = (float)(max + min) / 2;
		//printf("%d %d %.2f\n", min, max, T);
		int M = img.rows * img.cols;
		float T1 = 0.0;
		do {
			T1 = T;
			float mean1 = 0.0, mean2 = 0.0;
			int n1 = 0, n2 = 0;
			for (int i = 0; i < img.rows; i++) {
				for (int j = 0; j < img.cols; j++) {
					if (img(i, j) <= T) {
						mean1 += img(i, j);
						n1++;
					}
					else {
						mean2 += img(i, j);
						n2++;
					}
				}
			}
			mean1 = (float)mean1 / n1;
			mean2 = (float)mean2 / n2;

			T = (float)(mean1 + mean2) / 2;
			//printf("n1: %d, n2: %d, T: %.2f, T1: %.2f\n", n1, n2, T, T1);
		} while (T - T1 < ERR);

		
		Mat_<uchar> dest = Mat(img.rows, img.cols, CV_8UC1);
		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				if (img(i, j) <= T)
					dest(i, j) = 0;
				else
					dest(i, j) = 255;
			}
		}

		printf("%f\n", T);

		imshow("Source", img);
		imshow("Binarizare", dest);
		waitKey(0);
	}
}

void negativ() {
	Mat_<uchar> img;
	char file[MAX_PATH];

	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_GRAYSCALE);
		Mat_<uchar> dest = Mat(img.rows, img.cols, CV_8UC1);
		for (int i = 0; i < img.rows; i++) {
			for (int j = 0; j < img.cols; j++) {
				dest(i, j) = 255 - img(i, j);
			}
		}

		imshow("Original image", img);
		imshow("Negative image", dest);
		waitKey(0);
	}
}

void brightness() {
	Mat_<uchar> src;
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		src = imread(file, CV_LOAD_IMAGE_GRAYSCALE);
		int h = src.rows, w = src.cols;
		Mat_<uchar> dest = Mat(h, w, CV_8UC1);

		int offset = 0;
		printf("Offset: ");
		scanf("%d", &offset);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int aux = src(i, j) + offset;
				if (aux > 255)
					dest(i, j) = 255;
				else if (aux < 0)
					dest(i, j) = 0;
				else
					dest(i, j) = aux;
			}
		}

		imshow("Original", src);
		imshow("Brightness", dest);
		waitKey(0);
	}
}

void contrast() {
	int gmin = 256, gmax = -1;
	
	int min = 256, max = -1;
	Mat_<uchar> img, dest;
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		img = imread(file, CV_LOAD_IMAGE_GRAYSCALE);
		int h = img.rows, w = img.cols;
		dest = Mat(h, w, CV_8UC1);
		printf("gOutMin: "); scanf("%d", &gmin);
		printf("gOutMax: "); scanf("%d", &gmax);
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (img(i, j) < min) min = img(i, j);
				if (img(i, j) > max) max = img(i, j);
			}
		}

		float alpha = (float)(gmax - gmin) / (max - min);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int aux = img(i, j) * alpha;	
				dest(i, j) = aux;
			}
		}

		imshow("Original image", img);
		imshow("Contrast image", dest);
		waitKey(0);
	}
}


void gamma() {
	Mat_<uchar> src, dest;
	char file[MAX_PATH];
	const int L = 250;
	while (openFileDlg(file)) {
		src = imread(file, CV_LOAD_IMAGE_GRAYSCALE);
		int h = src.rows, w = src.cols;
		dest = Mat(h, w, CV_8UC1);
		float gamma = 0.0;
		printf("Coeficient gamma: ");
		scanf("%f", &gamma);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				float aux1 = (float)src(i, j) / L;
				float aux2 = std::powf(aux1, gamma);
				float aux = L * aux2;
				if (aux > 255)
					dest(i, j) = 255;
				else if (aux < 0)
					dest(i, j) = 0;
				else
					dest(i, j) = aux;
			}
		}

		imshow("Source", src);
		imshow("Gamma", dest);
		waitKey(0);
	}
}
int main()
{
	int op;
	do
	{
		system("cls");
		destroyAllWindows();
		printf("Menu:\n");
		/*printf(" 1 - Open image\n");
		printf(" 2 - Open BMP images from folder\n");
		printf(" 3 - Image negative - diblook style\n");
		printf(" 4 - BGR->HSV\n");
		printf(" 5 - Resize image\n");
		printf(" 6 - Canny edge detection\n");
		printf(" 7 - Edges in a video sequence\n");
		printf(" 8 - Snap frame from live video\n");
		printf(" 9 - Mouse callback demo\n");
		printf(" 10 - Negative Image\n");
		printf(" 11 - Add to Gray\n");
		printf(" 12 - Multiply To Gray \n");
		printf(" 13 - Inverted matrix \n");
		printf(" 14 - 4 Cadrane \n");
		printf(" 15 - Copy RGB\n");
		printf(" 16 - Convert to Grayscale\n");
		printf(" 17 - Convert to HSV\n");
		printf(" 18 - Calculate histogram\n");
		printf(" 19 - Determinare praguri multiple\n");
		printf(" 20 - Calculare Arie\n");
		printf(" 21 - Algoritm 1\n");
		printf(" 22 - Doua treceri\n");
		printf(" 23 - Urmarire contur\n");
		printf(" 24 - Construire Contur din fisier\n");
		printf(" 25 - Dilatare \n");
		printf(" 26 - Eroziunea \n");
		printf(" 27 - Deschidere \n");*/
		printf(" 28 - Inchidere \n");
		printf(" 29 - Contur \n");

		printf(" 30 - Media de intensitate\n");
		printf(" 31 - Deviatia\n");
		printf(" 32 - Binarizare\n");
		printf(" 33 - Negative image\n");
		printf(" 34 - Increase brightness\n");
		printf(" 35 - Contrast\n");
		printf(" 36 - Gamma\n");
		printf(" 0 - Exit\n\n");
		printf("Option: ");
		scanf("%d",&op);
		switch (op)
		{
			//case 1:
			//	testOpenImage();
			//	break;
			//case 2:
			//	testOpenImagesFld();
			//	break;
			//case 3:
			//	testParcurgereSimplaDiblookStyle(); //diblook style
			//	break;
			//case 4:
			//	//testColor2Gray();
			//	testBGR2HSV();
			//	break;
			//case 5:
			//	testResize();
			//	break;
			//case 6:
			//	testCanny();
			//	break;
			//case 7:
			//	testVideoSequence();
			//	break;
			//case 8:
			//	testSnap();
			//	break;
			//case 9:
			//	testMouseClick();
			//	break;
			//case 10:
			//	//negativeImage();
			//	negativeImage_refactor();
			//	break;
			//case 11:
			//	addToGray();
			//	break;
			//case 12:
			//	multiplyToGray();
			//	break;
			//case 13:
			//	invMat();
			//	break;
			//case 14:
			//	quattro();
			//	break;
			//case 15: 
			//	copyRGB();
			//	break;
			//case 16:
			//	convertToGrayscale();
			//	break;
			//case 17:
			//	convertToHSV();
			//	break;
			//case 18:
			//	calculateHistogram();
			//	break;
			//case 19:
			//	praguriMultiple();
			//	break;
			//
			//case 20:
			//	//calc_I();
			//	break;
			//case 21:
			//	algoritm1();
			//	break;
			//case 22: 
			//	algoritm2();
			//	break;
			//case 23:
			//	urmarireContur();
			//	break;
			//case 24:
			//	construireContur();
			//	break;
			//case 25:
			//	dilatare();
			//	break;
			//case 26:
			//	eroziune();
			//	break;
			//case 27:
			//	deschidere();
			//	break;
			//case 28:
			//	inchidere();
			//	break;
			//case 29:
			//	extragereContur();
			//	break;
			case 30:
				medie();
				break;	
			case 31:
				deviatie();
				break;
			case 32:
				binarizare();
				break;
			case 33:
				negativ();
				break;
			case 34:
				brightness();
				break;
			case 35:
				contrast();
				break;
			case 36:
				gamma();
				break;
		}

	}
	while (op!=0);
	return 0;
}
