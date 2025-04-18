# Multimodal Image + OCR Classifier

This project implements a multimodal classification pipeline using images and OCR (text) data. The model uses ResNet18 for image features and TF-IDF for text features, combined for final classification.

## 🧠 Features

- Uses both image and OCR text data for classification
- Built with PyTorch and Scikit-learn
- ResNet18 pretrained on ImageNet
- Custom PyTorch `Dataset` class for multimodal input
- Supports early stopping and model checkpointing

---

### 1. Clone the Repository
```
As per the shared mode 
Github--> git clone url
drive--> download and continue
```

### 2. Create a virtual environment and activate it:
```
python -m venv venv
source venv/bin/activate (for linux)
venv\Scripts\activate (for windows)
```
### 3.Install the required libraries:

```
pip install requirements.txt 
```

## Project structure



project_root/
│
├── data/
│   ├── images/
│   │   ├── class_name_0/
│   │   ├── class_name_2/
│   │   ├── class_name_4/
│   │   ├── class_name_6/
│   │   └── class_name_9/
│   └── ocr/
│       ├── class_name_0/
│       ├── class_name_2/
│       ├── class_name_4/
│       ├── class_name_6/
│       └── class_name_9/
│
├── notebook/
│   ├── best_model_v4.pth
│   └── hybrid_v4.ipynb
│
│
├── README.md
├── README.txt
│
├── reports/
│   ├── classification_statistics.txt
│
├── requirements.txt
│
├── saved_models/
    └── best_model_weights_v4.pth