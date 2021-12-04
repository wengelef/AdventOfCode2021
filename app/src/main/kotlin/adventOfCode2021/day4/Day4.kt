package adventOfCode2021.day4

typealias BingoBoard = List<MutableList<Day4.BingoValue>>

class Day4 {

    private val input = "28,82,77,88,95,55,62,21,99,14,30,9,97,92,94,3,60,22,18,86,78,71,61,43,79,33,65,81,26,49,47,51,0,89,57,75,42,35,80,1,46,83,39,53,40,36,54,70,76,38,50,23,67,2,20,87,37,66,84,24,98,4,7,12,44,10,29,5,48,59,32,41,90,17,56,85,96,93,27,74,45,25,15,6,69,16,19,8,31,13,64,63,34,73,58,91,11,68,72,52"
        .split(",")
        .map { s: String -> s.toInt() }

    private val boards = """
31 88 71 23 61
 4  9 14 93 51
52 50  6 34 55
70 64 78 65 95
12 22 41 60 57

44 54 26 63 18
32 74 99 52  2
 5 29 13 28 41
60 69 53 61 25
49 59 70 46 48

26 91  1 23  6
51 58 79 57 33
67 50 14 81 48
64 66 49 46  9
16 73 39 74 68

41 31 12 14 82
 4 97 76 49 15
50 43 72 22 24
53 56 78 33 52
65 68 26  0 94

73 21 23 33 57
53 10 40 35  0
41 12 71 19 47
49 25 76 78 13
80 92 22 26 29

97 11 43 46 52
51 58 36 47 84
75 69 88 85 57
67 94 61  0 70
65 42 16 44  1

64 70 99 58 56
18 81 34 59 45
26 71 67 47 68
78 17 87 91  0
49 98 53 35  9

76 75  5 27 25
17 92 42 49 28
34 78 26 71 30
11 31 41 14  8
50 59 62 93 80

 3 27 23 11 49
56 93 22 70 94
24 74 43 21  7
33 28 41 96  9
42 10 80 78  5

51 64 12 79 31
73 66 43 70 84
86 44 81 60 85
16 48  6 83 34
25 98 36 50 19

28 15 30 79 59
40 76 39 98 12
 4 96 93 91 47
19 75 89 73 17
72 64 92 58 74

24 32 84 57 55
91 33 92 71  8
30 40 78 61 70
79 35 34 75 23
38  7 81 27 76

 8 93 11 94 39
21 13 98 83 10
38 59 46 24 75
74 60 34 89 42
36 69  0 40 67

21 69 28 98 13
44 79  7  3 20
19 36 82  9 43
45 11 99 97 76
 2 17 16 46 66

73 20  2 63 47
 6 96 16 46 17
66 82 14 29 41
49 30 71  8 68
44 18 56 26 74

42 32 40  2  9
20 10 95 31 67
98 96 15 39 58
13 52 99 82 89
23 18 87 60  5

92 32 45 26 80
59 22 23 98 24
79 65 99 15 58
83 86 70 17 63
51 46 82 78 52

 3 73 20 53 63
26 97 39 94 55
 1 27 98 62 15
75 78 99 87 43
90 96  0 89 67

85 76 48 16 49
51 67 79 68 18
20 38 44 57 46
19 29 39 60 23
26 47 78 17 83

32 11 47 56 84
54 66 38 77 74
72  0 30 71 80
10 86 94 23 65
81 99 60 43 83

 7 78 69 75 41
 0 70 21 45 29
40 51 88 28 35
97 46 44 98 37
93 36 89 81 18

33 13 84 68 72
92 76  1 40 19
86 75 34 98 82
 8  3  4 28  0
91 60 27 81 39

76 32 92 65 70
88 45 37 44 99
38 95 72  6 19
34 71 54 41 33
47 20 84 98 73

85 46  4 89 69
50 62 30 64 59
 9 21 54 55 13
66 29 17 96  6
22 97 44 87 90

72 53 96 87 35
81 14 77 17 12
82 47  2 95 59
24 92 54 90 48
70  4 85 99 13

32 22  3 54 18
 4  2 94 38 77
46 59 11 67 37
61 80 45 51 95
13 81 42 15 64

24 51 56 36 55
84 81 78  1 98
33 14  3 97 64
34 39 11 18 59
44 62 99 83 82

73 21 47 83 10
11  5 16 20 54
36 98  4 89 38
56 72  6 32 80
29 91 61 40 69

19 22 53 67 34
59 94  5 47 61
77 55 91 69 63
92 68 65 40 97
64 20 18 39 49

 0 36 23 26 30
76 21 81 64  7
 3 61 93 79 70
96  8 47 48 54
51 55 44 62 59

70 69 89 91 55
19  8 29 59 54
64 56 51 34 60
32 16 37 44 83
40 21 50 66 76

54  1 83 64 26
27  9 52  6 50
68  4 45 30  2
93 42 89 70 99
67 19  7 59  0

75 28 98 83 18
82 71 96 40 24
47 52 73 69 34
 4 78 89 32 11
53 39 37 93 67

96 54  5 26 74
91 65 70 21  6
 4 80 89 30 51
63 99 73 11 49
10 29 18 98 34

 0 98 16 32 66
82 44 22 25 42
62 45 90 36 47
10 43 15 12  6
 1 86 20 27 28

83 68 61 16 60
 7 22 14 56 72
41 24 43 20 51
13 15 53 87 84
66 91  1 42 80

19  9 73 51 13
 0 52 43 26 59
20  2 12 78 56
42 64  6 65 85
61 11 35 44 84

28 30 96 67 38
89 50 20 92 40
 0 57  9 49 95
26 39 66  7 25
74 72 76 54 16

57 50 29 88 80
27 23  3 83 52
33 45  5  4 58
67 48 16 82 55
75 92 63 40 30

59 66 39 36 68
34 95 88 70 60
44  6 81  2 13
 5 83 33  0 37
17 97 46 82 84

98 87 20 49 22
 9 37 81 11 71
24 64 13 25 82
 8 34  3 94 36
16 45 73 85 23

 3 12 28 54 16
86 92 10 74 75
43  5 98 24 34
52 32 48 18 17
33 26 99 25 63

67  1 27 91  6
98 94 18 21 65
 9 17 80 82 70
84 47 26 96 46
38 89 57 78 22

89 86 51 84 27
47 61 35 26 18
22 79 28 78 21
15 77 65 46 64
 1 99 16 80 95

24 84  3 23 81
 1 57 25 30 48
67 91 68 15  2
31 73 50  4 16
61 99 47 96 34

41 86 47 15 93
31 88 80  6 16
54 55 24 81 77
84 97 91 42 37
48  7 94 98 34

35 51 30 68 59
16 27 34  0 84
90 47 28 96 72
33 76 74 64 52
32 46  3 26 83

 7 83 88 17 46
14 64 80 27 57
58 44 55 86 61
38  3 96 32 71
26 78 22 70 33

29 36 59 90 95
87 42 75 89  9
96  1 58 48 10
16  6 35 85  4
66 62 22 30 91

23 46 36 53 63
17 98 72 33 50
39 96 95 67 19
56 84 73 88 79
86 58 28 91 15

67 48 31 82 57
65 32 41 84 30
 3 87 94 68 35
56  9 28 50 27
36 21 72 81 55

21  8 99 15 75
85  5 12  0 53
82 45  4 11 43
88 95 69 44 81
 1 56 22 83 73

68 84 83 27 64
94 70 90 97 79
12 35 45 76 22
18 14 41  1 10
15  9 87 32 17

53 69 77 19 96
 5 47 64 57 23
26 28 88  6 41
16 52 51 93 30
95 33 98 46 42

34 85 39 82  0
17 60 40 12 93
56 72 58 31  3
78 47 63 20  1
80 54  8 94 24

12 90 86 33 56
55 16 24 65 72
82 28 53  1 93
14 69 11 41 29
92 37 48 57 15

 8 45 89 90 41
52 86 60 62 72
47 80 82 13 56
22 46 91 57 50
 9 67 43  6 16

 6 51 99 17 20
84 75 73 97 13
89 31 80  1 61
88 82 50 96 83
32 35 53 68 26

21  9 63 62 82
55 45 86 75 14
19 15 88 43 53
79 36 97 71 33
 4 85 52 47 12

81 77 12  1 28
32 38 16 41 91
64  8 63 78 54
87 24 23  0 22
99 75 18 15 65

22 82 41 54 89
68  5 70 11 81
17 94 73 24 77
99 56 21 75 14
48 67 76 64 95

85  5 54 31 37
38 74 69 52 53
86 89  6 81 40
26 84 56 72 65
67  7 32 87 95

45 49 86 53 94
20 40 28 26 98
36  4 67 29 87
70  1 96 55 48
37 92 23 85 91

77 85 32 21 62
46 69 16 98 71
 3 88 38 36  8
79 12 74 76 84
72 41 92 39 67

50 69  2 38 15
67 28 78 30 40
33 92 88 85 24
18  6 34 16 61
36 29 56 63 90

90 92 13 32 56
72 89 51 43 40
18  4 81 23 77
57 62 85 55 86
27 65 31 94 91

80 45 14 90 32
74 53 34  9 83
51 97 56 30 69
11 15 17 41  4
54 24 85 67 66

52 10 39 61 97
 4 49 73 58 74
19 45 92 27 32
41 11 75 37 70
95 53 88 86 82

19 35 77 73 11
97 54 24 50 39
68 59 56 80 75
72 85 38 67 40
49 25 98 94 26

63 37 58  7 81
69 65 44 86 22
38 66 82 93 64
36 15 61 88 45
25 91  6 60 87

 6  4 90 10 89
12  2 30 94 59
41 13 51 63  0
34 73 87 79 61
38 77 88 53 72

49 57 27 50 74
60 99 90 34  0
 7 80 43 24 65
82 67  2 69 20
72 75 47 18 91

12 55 65 36 92
40 99 15  7 82
 9 46 32 52 83
73 20 61 18 69
78 34 41 98 96

60 53 76 19 57
82 13 30 51 41
45 87 95 25 39
96 66 72 62 59
71  5 17 77 75

60 14  5 38 62
85 68 69 83 92
24 82 93 61 11
65 19 75 47 94
45 21 13 76 59

50 43 83 15 18
35 37 47 96 51
91  7 19 38  9
87 76 46 61 82
85 20 59 39 31

91 42 83 63 54
35 89 33 37 88
19 67 71 49 48
34 65  7  1 80
70  9 98 10 44

65 89  1 76 86
81 35 93 69 26
15 17 16 67  0
97 38 23 50 78
96 54 70 45 42

20 50 64 29 75
87 69 27 92 52
32 88 93 67  9
35 15 17 89 40
37 11 21  3 86

20  8 68 75 65
47 56  2 23 49
88 26  5 18  7
29 57 19 92 84
87 67 53 90 96

68 59 97 34 56
82 83 90 94 69
37 60 76 35  1
29 95 58 40 53
22 84 12 21 99

63 32 79 62 17
 8 18 40 74 57
71 91 70 30  3
46 33 39 61 76
27 54 12 98 77

73 66 24 65 76
88 42 52 11 32
41 15 81 89 33
74  3 25 75 83
29 14 96 35 27

23 36 57 53 93
43 50 83 97 91
63 69 55 90 11
18 94 59 85 73
81 60 30 46 80

32 13 51 86 39
74 46 11 25  9
44 89 26 54 71
93 98 29 75 85
38 70 79  0 30

68  4 55  3 96
41  7 64 21 86
27 69 93 80 90
73 75 26 25 50
49 32 45 24 61

90 14 43  4 87
11 16 33 79 28
36 31  2 34 50
67 10 24 92 99
26 80  1 12 51

56 21 79 36 93
26 63 35  5 76
85 94 69 18 28
52 55 90 83 12
10 23 95 15 19

34 85 32 89 16
 7 12 40 23 47
79 10 93 59 29
99 22 21 38  9
76  4 70 53 35

51 33 22 56 97
88 26 47 19 40
45  0  3 25 76
 8 42 61 57  5
83 20 53 29 70

 2 41 94 98 33
61 77 84 34  0
49 40 86 74 43
35 27 38 25  8
90 80 57 97 46

60  1 83 31 77
94 49 64  6 24
51 95 36 72 76
 8  7 59 45 34
26 87 41 97 82

13  7 69 28 78
39 62 45 77 53
90 85 23 17 38
60 33 19 89 24
97 30 16 64 42

23 73 59 52 70
20 38 81 78 47
58  0 79 19 95
39 42  8 17 53
24 57 37 13 10

36 60  3 98 41
30 27  0 74 81
49 23 48 69  4
22 86 73 96 95
80 14 92 83 91

86 61 22 77 57
34  4 71 55 27
25 24  7  6 16
81 75 38 96 35
64 15 29 98 79

82 85 80 52 56
72 58 89  8 92
43  5 77  2 83
53 12 39 21  6
16 31 47 10 74

43 17 37 53 48
60 77 80 36 25
58 20 91 95 71
90  4  9 83 66
28 15 62  6 11

51 46  2 26 79
83 52 11 64 22
66 49 61 78 69
70 67 91 10 24
68 63 23 93 35

42  9 63 56 93
79 59 38 36  7
 6 23 48  0 55
82 45 13 27 83
 1 32  8 40 46
    """.trimIndent()
        .split("\n\n")
        .map(::toBingoBoard)
        .toMutableSet()

    fun solve(): Int {
        for (draw in input) {
            boards.forEach { board -> board.mark(draw) }

            val iterator = boards.iterator()
            while (iterator.hasNext()) {
                val board = iterator.next()
                if (board.hasWinner()) {
                    iterator.remove()
                    if (boards.isEmpty()) return board.getSum { !it.marked } * draw
                }
            }
        }

        return 0
    }

    private fun BingoBoard.getSum(filter: (BingoValue) -> Boolean): Int {
        return sumOf { row -> row.filter(filter).sumOf { value -> value.number } }
    }

    private fun BingoBoard.hasWinner(): Boolean {
        return diagonal().hasWon ||
            straight { x, y -> get(y)[x] }.any { it.hasWon } ||
            straight { x, y -> get(x)[y] }.any { it.hasWon }
    }

    private fun BingoBoard.straight(selector: BingoBoard.(Int, Int) -> BingoValue): List<Row> {
        val rows = mutableListOf<Row>()
        for (y in this.indices) {
            val values = mutableListOf<BingoValue>()
            for (x in this[y].indices) {
                values.add(selector(y, x))
            }
            rows.add(Row(values.all { it.marked }))
        }
        return rows
    }

    private fun BingoBoard.diagonal(): Row {
        val values = mutableListOf<BingoValue>()
        for (y in this.indices) {
            values.add(this[y][y])
        }
        return Row(values.all { it.marked })
    }

    private fun BingoBoard.mark(draw: Int) {
        for (y in this.indices) {
            for (x in this[y].indices) {
                val bingoValue = this[x][y]
                if (bingoValue.marked) {
                    continue
                }
                if (bingoValue.number == draw) {
                    this[x][y] = bingoValue.copy(marked = true)
                    return
                }
            }
        }
    }

    private fun toBingoBoard(input: String) = input.split(" ", "\n")
        .asSequence()
        .filter { it.isNotBlank() }
        .map(String::toInt)
        .map(::BingoValue)
        .chunked(5)
        .map { it.toMutableList() }
        .toMutableList()

    data class Row(val hasWon: Boolean)

    data class BingoValue(val number: Int, val marked: Boolean = false)
}