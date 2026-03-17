<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    int gift3Price = 38000;
    int gift5Price = 52000;
    int home3Price = 30000;
    int home4Price = 47000;

    int gift3Count = 0;
    int gift5Count = 0;
    int home3Count = 0;
    int home4Count = 0;

    int gift3Total = 0;
    int gift5Total = 0;
    int home3Total = 0;
    int home4Total = 0;
    int grandTotal = 0;

    boolean isSubmitted = request.getMethod().equalsIgnoreCase("POST");

    if (isSubmitted) {
        try {
            gift3Count = Integer.parseInt(request.getParameter("gift3"));
            gift5Count = Integer.parseInt(request.getParameter("gift5"));
            home3Count = Integer.parseInt(request.getParameter("home3"));
            home4Count = Integer.parseInt(request.getParameter("home4"));

            gift3Total = gift3Count * gift3Price;
            gift5Total = gift5Count * gift5Price;
            home3Total = home3Count * home3Price;
            home4Total = home4Count * home4Price;
            grandTotal = gift3Total + gift5Total + home3Total + home4Total;
        } catch (Exception e) {
            gift3Count = 0;
            gift5Count = 0;
            home3Count = 0;
            home4Count = 0;
        }
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>선물용과 가정용 상품 구성</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            text-align: center;
        }
        caption {
            font-size: 22px;
            font-weight: bold;
            margin: 12px;
        }
        th, td {
            border: 2px solid black;
            padding: 10px;
        }
        thead th {
            background-color: #f3f3f3;
        }
        input[type="number"] {
            width: 80px;
            padding: 5px;
            text-align: center;
        }
        .btn-area {
            margin-top: 20px;
            text-align: center;
        }
        .result-title {
            margin-top: 30px;
            font-size: 20px;
            font-weight: bold;
            text-align: center;
        }
        .total-row {
            font-weight: bold;
            background-color: #ffe9a8;
        }
        .link-btn {
            display: inline-block;
            margin-top: 12px;
            padding: 8px 14px;
            border: 1px solid #333;
            text-decoration: none;
            color: black;
            background-color: #f7f7f7;
        }
    </style>
</head>
<body>

    <form method="post" action="">
        <table>
            <caption>선물용과 가정용 상품 구성</caption>
            <colgroup>
                <col style="background-color: bisque" />
                <col span="2" style="background-color: rgb(98, 142, 238)" />
                <col style="background-color: rgb(106, 203, 216)" />
            </colgroup>
            <thead>
                <tr>
                    <th>용도</th>
                    <th>중량</th>
                    <th>개수(상자 수)</th>
                    <th>상자당 가격</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td rowspan="2">선물용</td>
                    <td>3Kg</td>
                    <td>
                        <input type="number" name="gift3" min="0" value="<%= gift3Count %>">
                    </td>
                    <td><%= String.format("%,d원", gift3Price) %></td>
                </tr>
                <tr>
                    <td>5Kg</td>
                    <td>
                        <input type="number" name="gift5" min="0" value="<%= gift5Count %>">
                    </td>
                    <td><%= String.format("%,d원", gift5Price) %></td>
                </tr>
                <tr>
                    <td rowspan="2">가정용</td>
                    <td>3Kg</td>
                    <td>
                        <input type="number" name="home3" min="0" value="<%= home3Count %>">
                    </td>
                    <td><%= String.format("%,d원", home3Price) %></td>
                </tr>
                <tr>
                    <td>4Kg</td>
                    <td>
                        <input type="number" name="home4" min="0" value="<%= home4Count %>">
                    </td>
                    <td><%= String.format("%,d원", home4Price) %></td>
                </tr>
            </tbody>
        </table>

        <div class="btn-area">
            <input type="submit" value="총 가격 계산">
        </div>
    </form>

    <% if (isSubmitted) { %>
        <div class="result-title">계산 결과</div>

        <table style="margin-top:20px;">
            <colgroup>
                <col style="background-color: bisque" />
                <col span="2" style="background-color: rgb(98, 142, 238)" />
                <col style="background-color: rgb(106, 203, 216)" />
                <col style="background-color: lightyellow" />
            </colgroup>
            <thead>
                <tr>
                    <th>용도</th>
                    <th>중량</th>
                    <th>개수(상자 수)</th>
                    <th>상자당 가격</th>
                    <th>총 가격</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td rowspan="2">선물용</td>
                    <td>3Kg</td>
                    <td><%= gift3Count %></td>
                    <td><%= String.format("%,d원", gift3Price) %></td>
                    <td><%= String.format("%,d원", gift3Total) %></td>
                </tr>
                <tr>
                    <td>5Kg</td>
                    <td><%= gift5Count %></td>
                    <td><%= String.format("%,d원", gift5Price) %></td>
                    <td><%= String.format("%,d원", gift5Total) %></td>
                </tr>
                <tr>
                    <td rowspan="2">가정용</td>
                    <td>3Kg</td>
                    <td><%= home3Count %></td>
                    <td><%= String.format("%,d원", home3Price) %></td>
                    <td><%= String.format("%,d원", home3Total) %></td>
                </tr>
                <tr>
                    <td>4Kg</td>
                    <td><%= home4Count %></td>
                    <td><%= String.format("%,d원", home4Price) %></td>
                    <td><%= String.format("%,d원", home4Total) %></td>
                </tr>
                <tr class="total-row">
                    <td colspan="4">전체 합계</td>
                    <td><%= String.format("%,d원", grandTotal) %></td>
                </tr>
            </tbody>
        </table>
    <% } %>

</body>
</html>