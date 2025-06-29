from OCR import ExtractText,OCRPreprocessing
from Summary import summarize
import sys

def Run(ImagePath):
    OCRPreprocessing(ImagePath)
    Text = ExtractText()
    # print("ExtractText Done")
    # return Text
    return summarize(Text)

ImagePath = sys.stdin.read()  # Read input from Java
result = Run(ImagePath)
print(result)