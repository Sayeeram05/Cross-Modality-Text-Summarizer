# %%
import pytesseract
import cv2
from PIL import Image

# %%
def OpenImage(path):
     return cv2.imread(path)
 
def OCRPreprocessing(ImagePath):
    
    img = OpenImage(ImagePath)

    # Step 1: Convert to Grayscale
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    # Step 2: Invert the grayscale image (text becomes black if it was white)
    inverted = cv2.bitwise_not(gray)

    # Step 3: Apply simple binary threshold
    _, binary = cv2.threshold(inverted, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

    cv2.imwrite("temp/binary.jpg", binary)
    
    

# %%
def ExtractText():
    img = Image.open("temp/binary.jpg")
    ocr_result = pytesseract.image_to_string(img)
    # print(ocr_result)
    return ocr_result

# %%
