import sys

def summarize(text):
    print("Ragesh")
    return f"Summary: {text[:50]}..."  # Just a dummy function for now

if __name__ == "__main__":
    input_text = sys.stdin.read()  # Read input from Java
    result = summarize(input_text)
    print(result)
