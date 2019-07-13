from collections import Counter
from matplotlib import pyplot as plt
import numpy as np
import pandas as pd
import csv

# using the default csv library
# with open('data.csv') as csv_file:
#     csv_reader = csv.DictReader(csv_file)
#     lan_counter = Counter()
#     for r in csv_reader:
#         lan_counter.update(r['LanguagesWorkedWith'].split(';'))

# using pandas tool
data = pd.read_csv('data.csv')
ids = data['Responder_id']
lang_responses = data['LanguagesWorkedWith']
lan_counter = Counter()
for r in lang_responses:
    lan_counter.update(r.split(';'))

languages, popularity = map(list, zip(*lan_counter.most_common(15)))

plt.xkcd()
languages.reverse()
popularity.reverse()
plt.barh(languages, popularity)

plt.title('Most Popular Languages')
plt.xlabel('# of People Who Use')
plt.ylabel('Languages')
plt.tight_layout()
plt.show()
