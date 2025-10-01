import streamlit as st
import requests

BACKEND_URL = "http://backend:8080/hello"

st.title("マルチコンテナ サンプルアプリ 🚀")

if st.button("Say Hello"):
    try:
        response = requests.get(BACKEND_URL)
        if response.status_code == 200:
            st.success(response.text)
        else:
            st.error(f"Error from backend: {response.status_code}")
    except requests.exceptions.RequestException as e:
        st.error(f"Error contacting backend: {e}")
