#include "stdafx.h"
#include <queue>
#include "common.h"
#include <random>
#include <fstream>
#include "OpenCVApplication.h"

void treceJos() {
	int k = 2, c = 0;
	int w = 2 * k + 1;
	Mat_<uchar> src, dest;
	Mat_<uchar> H = Mat(w, w, CV_8UC1);
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		src = imread(file, CV_LOAD_IMAGE_GRAYSCALE);
		
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < w; j++) {
				H(i, j) = src(i, j);
				c += H(i, j);
			}
		}

		Mat_<uchar> dest;
		dest = Mat(src.rows, src.cols, CV_8UC1);
		for (int i = 0; i < src.rows; i++) {
			for (int j = 0; j < src.cols; j++) {
				int destVal = 0;
				for (int u = 0; u < w; u++) {
					for (int v = 0; v < w; v++) {
						int ii = i + u - k;
						int jj = j + v - k;
						if (!(ii < 0 || jj < 0 || ii >= src.rows || jj >= src.cols)) {
							destVal += (src(ii, jj) * H(u, v));
						}
					}
				}
				destVal = destVal / c;
				dest(i, j) = destVal;
			}
		}

		imshow("Source", src);
		imshow("Trece Jos", dest);
		waitKey(0);
	}
}

void treceSus() {
	int k = 1;
	int w = 2 * k + 1;
	Mat_<uchar> H = Mat(w, w, CV_8UC1);

	H(0, 0) = -1;
	H(0, 1) = -1;
	H(0, 2) = -1;
	H(1, 0) = -1;
	H(1, 1) = 8;
	H(1, 2) = -1;
	H(2, 0) = -1;
	H(2, 1) = -1;
	H(2, 2) = -1;

	int Fp = 0, Fn = 0;
	for (int i = 0; i < w; i++) {
		for (int j = 0; j < w; j++) {
			if (H(i, j) > 0) Fp += H(i, j);
			else Fn += abs(H(i, j));
		}
	}
	
	float S = 1.0f / (2 * max(Fp, Fn));

	Mat_<uchar> src, dest;
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		src = imread(file, CV_LOAD_IMAGE_GRAYSCALE);
		dest = Mat(src.rows, src.cols, CV_8UC1);

		for (int i = 0; i < src.rows; i++) {
			for (int j = 0; j < src.cols; j++) {
				int destVal = 0;
				for (int u = 0; u < w; u++) {
					for (int v = 0; v < w; v++) {
						int ii = i + u - k;
						int jj = j + v - k;
						if (!(ii < 0 || jj < 0 || ii >= src.rows || jj >= src.cols)) {
							destVal += (src(ii, jj) * H(u, v) + 255 / 2);
						}
					}
				}
				destVal *= S;
				dest(i, j) = destVal;
			}
		}
		imshow("Source", src);
		imshow("Trece Sus", dest);
		waitKey(0);
	}
}

void centering_transform(Mat_<float> img) {
	for (int i = 0; i < img.rows; i++) {
		for (int j = 0; j < img.cols; j++) {
			img(i, j) = ((i + 1) & 1) ? -img(i, j) : img(i, j);
		}
	}
}

void generic_freq_domain_filter(Mat_<uchar> src) {
	imshow("Source", src);
	Mat_<float> srcf;
	src.convertTo(srcf, CV_32FC1);
	centering_transform(srcf);
	Mat fourier;
	dft(srcf, fourier, DFT_COMPLEX_OUTPUT);

	Mat ch[] = { Mat::zeros(src.size(), CV_32F), Mat::zeros(src.size(), CV_32F) };
	split(fourier, ch);

	Mat mag, phi;
	magnitude(ch[0], ch[1], mag);
	phase(ch[0], ch[1], phi);

	imshow("Magnitude", mag);
	imshow("Phase", phi);

	//operatii de filtrare

	//memorare parte reala in ch[0] si imaginara in ch[1]

	Mat dst, dstf;
	merge(ch, 2, fourier);
	dft(fourier, dstf, DFT_INVERSE | DFT_REAL_OUTPUT | DFT_SCALE);
	centering_transform(dstf);
	//normalize(dstf, dst, 0, 255, NORM_MINMAX, CV_8UC1);
	dstf.convertTo(dst, CV_8UC1);
	imshow("Dest", dst);
}

void fourier() {
	Mat_<uchar> src;
	char file[MAX_PATH];
	while (openFileDlg(file)) {
		src = imread(file, CV_LOAD_IMAGE_GRAYSCALE);
		generic_freq_domain_filter(src);

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
		printf(" 38 - Trece Jos\n");
		printf(" 39 - Trece Sus\n");
		printf(" 40 - Fourier\n");
		printf(" 0 - Exit\n\n");
		printf("Option: ");
		scanf("%d", &op);
		switch (op)
		{
		case 38:
			treceJos();
			break;
		case 39:
			treceSus();
			break;
		case 40:
			fourier();
			break;
		}

	} while (op != 0);
	return 0;
}
