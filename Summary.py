# %%
from transformers import AutoTokenizer, AutoModelForSeq2SeqLM


def summarize(blog_post):   
    
    save_path = "./saved_models/Model4"

    # Load the trained model and tokenizer
    tokenizer = AutoTokenizer.from_pretrained(save_path)
    model = AutoModelForSeq2SeqLM.from_pretrained(save_path)
    
    # Tokenize the input blog post
    inputs = tokenizer(blog_post, max_length=524, truncation=True, return_tensors="pt")

    # Generate the summary
    # summary_ids = model.generate(inputs["input_ids"], max_length=524, min_length=25, length_penalty=2.0, num_beams=8, early_stopping=False)
    summary_ids = model.generate(inputs["input_ids"], max_length=212, min_length=25, length_penalty=2.0, num_beams=4, early_stopping=True) 

    # Decode the summary
    summary = tokenizer.decode(summary_ids[0],skip_special_tokens=True)
    return summary


# %%



